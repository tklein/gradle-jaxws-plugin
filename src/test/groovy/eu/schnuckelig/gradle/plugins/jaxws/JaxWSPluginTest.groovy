/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package eu.schnuckelig.gradle.plugins.jaxws

import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.gradle.api.DefaultTask
import org.gradle.api.Project;
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;
import static junit.framework.Assert.*;

public class JaxWSPluginTest {

	@Test
	public void pluginAppliesJavaPluginIfMissing(){
		// This can probably be more cleverly handled. Perhaps 
		Project project = ProjectBuilder.builder().build()
		project.apply plugin:"jaxws"
		assert project.tasks.compileJava instanceof JavaCompile
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
