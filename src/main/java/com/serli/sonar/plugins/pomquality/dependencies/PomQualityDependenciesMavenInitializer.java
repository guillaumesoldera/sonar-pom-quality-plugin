package com.serli.sonar.plugins.pomquality.dependencies;

import org.sonar.api.batch.Initializer;
import org.sonar.api.batch.maven.DependsUponMavenPlugin;
import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;

public class PomQualityDependenciesMavenInitializer extends Initializer implements DependsUponMavenPlugin {

  private PomQualityDependenciesMavenPluginHandler handler;

  public PomQualityDependenciesMavenInitializer(PomQualityDependenciesMavenPluginHandler handler) {
    this.handler = handler;
  }

  public MavenPluginHandler getMavenPluginHandler(Project project) {
    if (project.getAnalysisType().equals(Project.AnalysisType.DYNAMIC)) {
      return handler;
    }
    return null;
  }

  @Override
  public boolean shouldExecuteOnProject(Project project) {
    return project.getAnalysisType().isDynamic(true) &&
        project.getFileSystem().resolvePath("pom.xml") != null;
  }

  @Override
  public void execute(Project project) {
//    Configuration conf = project.getConfiguration();
//    if (!conf.containsKey(CoreProperties.COBERTURA_REPORT_PATH_PROPERTY)) {
      String report = getReportPathFromPluginConfiguration(project);
      if (report == null) {
        report = getDefaultReportPath(project);
      }
//      conf.setProperty(CoreProperties.COBERTURA_REPORT_PATH_PROPERTY, report);
//    }
  }

  private static String getDefaultReportPath(Project project) {
    return project.getFileSystem().getBuildDir() + "/reports/dependencies-analysis.xml";
  }

  private static String getReportPathFromPluginConfiguration(Project project) {
    MavenPlugin mavenPlugin = MavenPlugin.getPlugin(
        project.getPom(),
        PomQualityUtils.GROUP_ID,
        PomQualityUtils.ARTIFACT_ID);
    if (mavenPlugin != null) {
      String path = mavenPlugin.getParameter("outputDirectory");
      if (path != null) {
        return path + "reports/dependencies-analysis.xml";
      }
    }
    return null;
  }

}