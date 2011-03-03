package com.serli.sonar.plugins.pomquality;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.Plugin;

import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesDashboardWidget;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenInitializer;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenPluginHandler;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMetrics;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesSensor;

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
    liste.add(PomQualityDependenciesMetrics.class);
    liste.add(PomQualityDependenciesSensor.class);
    liste.add(PomQualityDependenciesDashboardWidget.class);
    liste.add(PomQualityDependenciesMavenPluginHandler.class);
    liste.add(PomQualityDependenciesMavenInitializer.class);
    return liste;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }
}
