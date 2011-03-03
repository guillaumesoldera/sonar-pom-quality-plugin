package com.serli.sonar.plugins.pomquality.dependencies;

import java.io.File;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.dependencies.api.PomQualityDependenciesParser;

public class PomQualityDependenciesSensor implements Sensor {

  private static Logger LOG = LoggerFactory.getLogger(PomQualityDependenciesSensor.class);
  
  private MavenProject mavenProject;
  
  public boolean shouldExecuteOnProject(Project project) {
    return (project.getFileSystem().resolvePath("pom.xml") != null);
  }

  public void analyse(Project project, SensorContext sensorContext) {
//    saveLabelMeasure(sensorContext);
//    saveNumericMeasure(sensorContext);
    File report = PomQualityUtils.getReport(project, mavenProject);
    if (report != null) {
      LOG.info("Dependencies analysis report founded at " + report.getPath());
      parseReport(report, sensorContext);
    }
    
  }

  private void parseReport(File report, SensorContext sensorContext) {
    PomQualityDependenciesParser parser = new PomQualityDependenciesParser();
    parser.parseReport(report, sensorContext);
  }

  private void saveNumericMeasure(SensorContext context) {
    // Sonar API includes many libraries like commons-lang and google-collections
    context.saveMeasure(PomQualityDependenciesMetrics.RANDOM, RandomUtils.nextDouble());
  }

  private void saveLabelMeasure(SensorContext context) {
    Measure measure = new Measure(PomQualityDependenciesMetrics.MESSAGE, "Hello World!");
    context.saveMeasure(measure);
  }
}
