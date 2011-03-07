package com.serli.sonar.plugins.pomquality;

import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.resources.Project;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;

public abstract class AbstractPomQualityMavenPluginHandler implements MavenPluginHandler {
  
  
  public abstract void configure(Project project, MavenPlugin qualityPlugin);

  public String getArtifactId() {
    return PomQualityUtils.ARTIFACT_ID;
  }

  public String getGroupId() {
    return PomQualityUtils.GROUP_ID;
  }

  public String getVersion() {
    return PomQualityUtils.VERSION;
  }

  public boolean isFixedVersion() {
    return false;
  }

}
