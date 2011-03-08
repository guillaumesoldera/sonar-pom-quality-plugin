package com.serli.sonar.plugins.pomquality.dependencies;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.AbstractPomQualitySensor;
import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.dependencies.api.PomQualityDependenciesParser;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.DeclaredDependency;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.Dependencies;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.ExclusionDependency;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.MultipleDeclarationDependency;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.OverridingDependencyVersion;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.UndeclaredDependency;

public class PomQualityDependenciesSensor extends AbstractPomQualitySensor {


  protected void parseReport(File report, SensorContext sensorContext) {
    PomQualityDependenciesParser parser = new PomQualityDependenciesParser();
    parser.parseReport(report, sensorContext, new Class[] { DeclaredDependency.class, UndeclaredDependency.class, ExclusionDependency.class, MultipleDeclarationDependency.class, OverridingDependencyVersion.class, Dependencies.class });
  }

  @Override
  protected File getReport(Project project, MavenProject mavenProject) {
    return PomQualityUtils.getDependenciesAnalyzeReport(project, mavenProject);
  }
}
