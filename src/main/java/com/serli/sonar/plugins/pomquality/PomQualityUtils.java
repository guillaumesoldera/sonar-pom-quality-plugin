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
  
  public static File getReport(Project project, MavenProject mavenProject) {
    File report = getReportFromPluginConfiguration(project, mavenProject);
    if (report == null) {
      report = getReportFromDefaultPath(project);
    }

    if (report == null || !report.exists() || !report.isFile()) {
      Logs.INFO.warn("PomQuality report not found at {}", report);
      report = null;
    }
    return report;
  }
  
  private static File getReportFromPluginConfiguration(Project project, MavenProject mavenProject) {
    MavenPlugin mavenPlugin = MavenPlugin.getPlugin(mavenProject, GROUP_ID, ARTIFACT_ID);
    if (mavenPlugin != null) {
      String path = mavenPlugin.getParameter("outputDirectory");
      System.out.println("path = " + path);
      if (path != null) {
        return project.getFileSystem().resolvePath(path + "reports/dependencies-analysis.xml");
      }
    }
    return null;
  }

  private static File getReportFromDefaultPath(Project project) {
    return new File(project.getFileSystem().getBuildDir(), "reports/dependencies-analysis.xml");
  }

  private PomQualityUtils() {
  }
}
