/**
 * 
 */
package eu.schnuckelig.gradle.plugins.jaxws

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 * Generates XML Binding classes from a set of XML Schemas.
 *
 * @author Thorsten Klein
 */
public class JaxWSTask extends DefaultTask {
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
		
        ant.taskdef(name:'wsimport',
		            classname:'com.sun.tools.ws.ant.WsImport',
		            classpath: project.configurations.jaxws.asPath)
		ant.wsimport(keep:true,
                 package: project.jaxws.packageName,
                 sourcedestdir: outputDirectory,
                 wsdl: project.jaxws.wsdlURL,
				 xendorsed: true,
				 xnocompile: true)
    }
}
