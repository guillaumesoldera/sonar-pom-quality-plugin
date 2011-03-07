package com.serli.sonar.plugins.pomquality.mavenconventions;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityMavenInitializer;

public class PomQualityMavenConventionsMavenInitializer extends AbstractPomQualityMavenInitializer {

  public PomQualityMavenConventionsMavenInitializer(PomQualityMavenConventionsMavenPluginHandler handler) {
    super(handler, "/reports/maven-conventions-check.xml");
  }

}