package com.serli.sonar.plugins.pomquality;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenInitializer;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenPluginHandler;

public class PomQualityMavenInitializerTest {

  private Project project;
  private PomQualityDependenciesMavenInitializer initializer;

  @Before
  public void setUp() {
    project = mock(Project.class);
    initializer = new PomQualityDependenciesMavenInitializer(new PomQualityDependenciesMavenPluginHandler());
  }

  @Test
  public void doNotExecuteMavenPluginIfReuseReports() {
    when(project.getAnalysisType()).thenReturn(Project.AnalysisType.REUSE_REPORTS);
    assertThat(initializer.getMavenPluginHandler(project), nullValue());
  }

  @Test
  public void doNotExecuteMavenPluginIfStaticAnalysis() {
    when(project.getAnalysisType()).thenReturn(Project.AnalysisType.STATIC);
    assertThat(initializer.getMavenPluginHandler(project), nullValue());
  }
  
  @Test
  public void executeMavenPluginIfDynamicAnalysis() {
    when(project.getAnalysisType()).thenReturn(Project.AnalysisType.DYNAMIC);
    assertThat(initializer.getMavenPluginHandler(project), not(nullValue()));
    assertThat(initializer.getMavenPluginHandler(project).getArtifactId(), is("maven-quality-plugin"));
  }
  
}
