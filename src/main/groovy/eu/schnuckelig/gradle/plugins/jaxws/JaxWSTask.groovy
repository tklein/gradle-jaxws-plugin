/**
 * 
 */
package eu.schnuckelig.gradle.plugins.jaxws

import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction

/**
 * Generates XML Binding classes from a set of XML Schemas.
 *
 * @author Thorsten Klein
 */
public class JaxWSTask extends SourceTask {
    /**
     * The classpath containing the Ant XJC task implementation.
     * <p>
     * This is implemented dynamically from the task's convention mapping setup in <code>JaxbPlugin</code>
     *
     * @see JaxbPlugin
     */
    @InputFiles
    FileCollection getJaxwsClasspath() {
        null
    }

    /**
     * The directory to generate the parser source files into
     */
    @OutputDirectory
    File outputDirectory

    @TaskAction
    def generate() {
        // TODO how to get to the task's SourceSetOutput which holds the resources dir
        def metaInfDirectory = "${project.buildDir}/resources/main/META-INF"
        project.file(metaInfDirectory).mkdirs()
		
//        def xjcLibs = jaxWSClasspath + project.configurations.antextension

        ant.taskdef(name:'wsimport',
		            classname:'com.sun.tools.ws.ant.WsImport',
		            classpath: project.configurations.jaxws.asPath)
		ant.wsimport(keep:true,
                 destdir: sourceSets.main.output.classesDir,
                 package: project.configurations.jaxws.package,
                 sourcedestdir: outputDirectory,
                 wsdl: project.configurations.jaxws.wsdl,
				 xendorsed: true)
		
//        ant.xjc(extension: true, catalog: 'src/main/xsd/catalog.cat', destdir: outputDirectory, classpath: project.configurations.compile.asPath) {
//            source.addToAntBuilder(ant, 'schema', FileCollection.AntType.FileSet)
//            arg(value: '-verbose')
//            arg(value: '-episode')
//            arg(value: "${metaInfDirectory}/sun-jaxb.episode")
//        }
    }
}
