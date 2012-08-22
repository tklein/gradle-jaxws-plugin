package eu.schnuckelig.gradle.plugins.jaxws

import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.gradle.api.DefaultTask
import org.gradle.api.Project;
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.compile.Compile;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;
import static junit.framework.Assert.*;

public class JaxWSPluginTest {

	@Test
	public void pluginAppliesJavaPluginIfMissing(){
		// This can probably be more cleverly handled. Perhaps 
		Project project = ProjectBuilder.builder().build()
		project.apply plugin:"jaxws"
		assert project.tasks.compileJava instanceof Compile
	}
	
	@Test
	public void jaxwsPluginAddsWsimportTaskToProject() {
		Project project = ProjectBuilder.builder().build()
		project.apply plugin: 'jaxws'

		assertTrue(project.tasks.wsimport instanceof JaxWSTask)
	}
	
	@Test
	public void pluginCustomGeneratedSourceSetIsNull() {
		Project project = ProjectBuilder.builder().build()
		project.apply plugin:"java"
		project.apply plugin:"jaxws"
		assertEquals(null, project.jaxws.sourceDir)
	}
	
	@Test
	public void pluginAddsDefaultGeneratedSourceSet() {
		Project project = ProjectBuilder.builder().build()
		project.apply plugin:"java"
		project.apply plugin:"jaxws"
		
		assert project.tasks.wsimport.outputDirectory
	}
	
	
//	@Test
//	public void pluginAddsIntTestSourceSet() {
//		Project project = ProjectBuilder.builder().build()
//		project.apply plugin:"java"
//		project.apply plugin:"jaxws"
//		assert project.sourceSets.intTest
//	}
}
