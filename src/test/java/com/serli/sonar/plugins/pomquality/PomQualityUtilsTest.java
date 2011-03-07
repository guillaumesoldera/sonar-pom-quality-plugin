package com.serli.sonar.plugins.pomquality;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.maven.project.MavenProject;
import org.junit.Test;
import org.sonar.api.resources.DefaultProjectFileSystem;
import org.sonar.api.resources.Project;
import org.sonar.api.test.MavenTestUtils;

public class PomQualityUtilsTest {

  @Test
  public void shouldGetReportPathFromPom() {
    MavenProject pom = MavenTestUtils.loadPom("/com/serli/sonar/plugins/pomquality/PomQualityUtils/shouldGetReportPathFromPom/pom.xml");

    DefaultProjectFileSystem fileSystem = mock(DefaultProjectFileSystem.class);

    Project project = mock(Project.class);
    when(project.getPom()).thenReturn(pom);
    when(project.getFileSystem()).thenReturn(fileSystem);

    PomQualityUtils.getDependenciesAnalyzeReport(project, pom);

    verify(fileSystem).resolvePath("overridden/dir/reports/dependencies-analysis.xml");
  }
}
