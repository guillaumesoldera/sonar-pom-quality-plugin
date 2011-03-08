package com.serli.sonar.plugins.pomquality;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

public abstract class AbstractPomQualitySensor implements Sensor {

  private static Logger log = LoggerFactory.getLogger(AbstractPomQualitySensor.class);
  
  private MavenProject mavenProject;

  public boolean shouldExecuteOnProject(Project project) {
    return (project.getFileSystem().resolvePath("pom.xml") != null);
  }

  public void analyse(Project project, SensorContext sensorContext) {
    // saveLabelMeasure(sensorContext);
    // saveNumericMeasure(sensorContext);
    File report = getReport(project, mavenProject);
    if (report != null) {
      log.info("Dependencies analysis report founded at " + report.getPath());
      parseReport(report, sensorContext);
    }

  }

  protected abstract File getReport(Project project, MavenProject mavenProject);
  
  protected abstract void parseReport(File report, SensorContext sensorContext);
}
