package com.serli.sonar.plugins.pomquality.dependencies;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;
import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenPluginHandler;


public class PomQualityDependenciesMavenPluginHandlerTest {

  protected PomQualityDependenciesMavenPluginHandler handler;
  
  @Before
  public void before() {
    handler = new PomQualityDependenciesMavenPluginHandler();
  }
  
  @Test
  public void notFixedVersion() {
    assertThat(new PomQualityDependenciesMavenPluginHandler().isFixedVersion(), is(false));
  }
  
  @Test
  public void notFailOnWarning() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("failOnWarning"), is("false"));
  }

  @Test
  public void notIgnoreNonCompile() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("ignoreNonCompile"), is("false"));
  }

  @Test
  public void activateAnalyzeDepMgt() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("analyzeDepMgt"), is("true"));
  }

  @Test
  public void activateUniqueDeclaration() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("uniqueDeclaration"), is("true"));
  }

  @Test
  public void notIgnoreDirect() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("ignoreDirect"), is("false"));
  }
  
  @Test
  public void notLogConsole() {
    Project project = mock(Project.class);
    when(project.getConfiguration()).thenReturn(new PropertiesConfiguration());
    when(project.getPom()).thenReturn(new MavenProject());
    when(project.getExclusionPatterns()).thenReturn(new String[0]);

    MavenPlugin qualityPlugin = new MavenPlugin(PomQualityUtils.GROUP_ID, PomQualityUtils.ARTIFACT_ID, PomQualityUtils.VERSION);
    handler.configure(project, qualityPlugin);

    assertThat(qualityPlugin.getParameter("logConsole"), is("false"));
  }
}
