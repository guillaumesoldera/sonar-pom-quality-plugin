package com.serli.sonar.plugins.pomquality.mavenconventions;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.AbstractPomQualitySensor;
import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.mavenconventions.api.PomQualityMavenConventionsParser;
import com.serli.sonar.plugins.pomquality.mavenconventions.jaxb.MavenConventionsViolation;
import com.serli.sonar.plugins.pomquality.mavenconventions.jaxb.Violation;

public class PomQualityMavenConventionsSensor extends AbstractPomQualitySensor {

  protected void parseReport(File report, SensorContext sensorContext) {
    PomQualityMavenConventionsParser parser = new PomQualityMavenConventionsParser();
    parser.parseReport(report, sensorContext, new Class[]{Violation.class, MavenConventionsViolation.class});
  }

  @Override
  protected File getReport(Project project, MavenProject mavenProject) {
    return PomQualityUtils.getMavenConventionsReport(project, mavenProject);
  }

}
