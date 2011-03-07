package com.serli.sonar.plugins.pomquality.dependencies;

import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityMavenPluginHandler;
import com.serli.sonar.plugins.pomquality.PomQualityUtils;

public class PomQualityDependenciesMavenPluginHandler extends AbstractPomQualityMavenPluginHandler {
  
  
  public void configure(Project project, MavenPlugin qualityPlugin) {
    qualityPlugin.setParameter("failOnWarning", "false");
    qualityPlugin.setParameter("ignoreNonCompile", "false");
    qualityPlugin.setParameter("analyzeDepMgt", "true");
    qualityPlugin.setParameter("uniqueDeclaration", "true");
    qualityPlugin.setParameter("ignoreDirect", "false");
    qualityPlugin.setParameter("logConsole", "false");
  }

  public String[] getGoals() {
    return new String[] {PomQualityUtils.GOAL_ANALYZE_DEPENDENCIES};
  }

}