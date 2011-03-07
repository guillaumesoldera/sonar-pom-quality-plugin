package com.serli.sonar.plugins.pomquality.mavenconventions;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.mavenconventions.api.PomQualityMavenConventionsParser;
import com.serli.sonar.plugins.pomquality.mavenconventions.jaxb.MavenConventionsViolation;
import com.serli.sonar.plugins.pomquality.mavenconventions.jaxb.Violation;

public class PomQualityMavenConventionsSensor implements Sensor {

  private static Logger LOG = LoggerFactory.getLogger(PomQualityMavenConventionsSensor.class);

  private MavenProject mavenProject;

  public boolean shouldExecuteOnProject(Project project) {
    return (project.getFileSystem().resolvePath("pom.xml") != null);
  }

  public void analyse(Project project, SensorContext sensorContext) {
    // saveLabelMeasure(sensorContext);
    // saveNumericMeasure(sensorContext);
    File report = PomQualityUtils.getMavenConventionsReport(project, mavenProject);
    if (report != null) {
      LOG.info("Dependencies analysis report founded at " + report.getPath());
      parseReport(report, sensorContext);
    }

  }

  protected void parseReport(File report, SensorContext sensorContext) {
    PomQualityMavenConventionsParser parser = new PomQualityMavenConventionsParser();
    parser.parseReport(report, sensorContext, new Class[]{Violation.class, MavenConventionsViolation.class});
  }

}
