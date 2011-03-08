package com.serli.sonar.plugins.pomquality;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.resources.Project;
import org.sonar.api.utils.Logs;

public final class PomQualityUtils {

  public static final String GROUP_ID = "com.serli.maven.plugins";

  public static final String ARTIFACT_ID = "maven-quality-plugin";

  public static final String VERSION = "1.0-SNAPSHOT";

  public static final String GOAL_ANALYZE_DEPENDENCIES = "analyze-dependencies";

  public static final String GOAL_MAVEN_CONVENTION = "check-maven-conventions";
  
  public static final String REPOSITORY_KEY = "pomquality";
  
  public static File getDependenciesAnalyzeReport(Project project, MavenProject mavenProject) {
    return getReport(project, mavenProject, "reports/dependencies-analysis.xml");
  }
  
  public static File getMavenConventionsReport(Project project, MavenProject mavenProject) {
    return getReport(project, mavenProject, "reports/maven-conventions-check.xml");
  }
  
  public static File getReport(Project project, MavenProject mavenProject, String file) {
    File report = getReportFromPluginConfiguration(project, mavenProject, file);
    if (report == null) {
      report = getReportFromDefaultPath(project, file);
    }

    if (report == null || !report.exists() || !report.isFile()) {
      Logs.INFO.warn("PomQuality report not found at {}", report);
      report = null;
    }
    return report;
  }
  
  private static File getReportFromPluginConfiguration(Project project, MavenProject mavenProject, String file) {
    MavenPlugin mavenPlugin = MavenPlugin.getPlugin(mavenProject, GROUP_ID, ARTIFACT_ID);
    if (mavenPlugin != null) {
      String path = mavenPlugin.getParameter("outputDirectory");
      if (path != null) {
        return project.getFileSystem().resolvePath(path + file);
      }
    }
    return null;
  }

  private static File getReportFromDefaultPath(Project project, String file) {
    return new File(project.getFileSystem().getBuildDir(), file);
  }

  private PomQualityUtils() {
  }
}
