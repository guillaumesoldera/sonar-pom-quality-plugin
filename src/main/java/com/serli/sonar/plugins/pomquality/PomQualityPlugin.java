package com.serli.sonar.plugins.pomquality;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.Plugin;

import com.serli.sonar.plugins.pomquality.dependencies.api.PomQualityDependenciesUtils;
import com.serli.sonar.plugins.pomquality.mavenconventions.api.PomQualityMavenConventionsUtils;

/**
 * This class is the entry point for all extensions
 */
public class PomQualityPlugin implements Plugin {

  /**
   * @deprecated this is not used anymore
   */
  public String getKey() {
    return "pomquality";
  }

  /**
   * @deprecated this is not used anymore
   */
  public String getName() {
    return "Pom Quality Sonar Plugin";
  }

  /**
   * @deprecated this is not used anymore
   */
  public String getDescription() {
    return "Sonar plugin for pom quality analysis";
  }

  // This is where you're going to declare all your Sonar extensions
  public List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> liste = new ArrayList<Class<? extends Extension>>();
    liste.addAll(PomQualityDependenciesUtils.getExtensions());
    liste.addAll(PomQualityMavenConventionsUtils.getExtensions());
    return liste;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
