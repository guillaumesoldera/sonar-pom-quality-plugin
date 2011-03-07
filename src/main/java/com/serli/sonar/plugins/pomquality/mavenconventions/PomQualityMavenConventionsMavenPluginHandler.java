package com.serli.sonar.plugins.pomquality.mavenconventions;

import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityMavenPluginHandler;
import com.serli.sonar.plugins.pomquality.PomQualityUtils;

public class PomQualityMavenConventionsMavenPluginHandler extends AbstractPomQualityMavenPluginHandler {
  
  
  public void configure(Project project, MavenPlugin qualityPlugin) {
    qualityPlugin.setParameter("logConsole", "false");
  }

  public String[] getGoals() {
    return new String[] {PomQualityUtils.GOAL_MAVEN_CONVENTION};
  }

}