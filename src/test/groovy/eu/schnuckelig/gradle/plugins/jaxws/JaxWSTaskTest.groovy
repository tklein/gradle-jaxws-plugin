/**
 * 
 */
package eu.schnuckelig.gradle.plugins.jaxws;

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project

import eu.schnuckelig.gradle.plugins.jaxws.JaxWSTask;
import static org.junit.Assert.*

/**
 * @author grobie
 *
 */
public class JaxWSTaskTest {

	    @Test
	    public void canAddTaskToProject() {
	        Project project = ProjectBuilder.builder().build()
	        def task = project.task('wsimport', type: JaxWSTask)
	        assertTrue(task instanceof JaxWSTask)
	    }
	}