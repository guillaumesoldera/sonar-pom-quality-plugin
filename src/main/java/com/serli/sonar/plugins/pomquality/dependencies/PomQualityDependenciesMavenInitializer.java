package com.serli.sonar.plugins.pomquality.dependencies;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityMavenInitializer;

public class PomQualityDependenciesMavenInitializer extends AbstractPomQualityMavenInitializer {

  public PomQualityDependenciesMavenInitializer(PomQualityDependenciesMavenPluginHandler handler) {
    super(handler, "/reports/dependencies-analysis.xml");
  }

}