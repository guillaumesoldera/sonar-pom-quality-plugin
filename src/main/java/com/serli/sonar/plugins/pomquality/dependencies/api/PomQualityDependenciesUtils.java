package com.serli.sonar.plugins.pomquality.dependencies.api;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;

import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesDashboardWidget;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenInitializer;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMavenPluginHandler;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMetrics;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesSensor;

public final class PomQualityDependenciesUtils {

  public static List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> liste = new ArrayList<Class<? extends Extension>>();
    liste.add(PomQualityDependenciesMetrics.class);
    liste.add(PomQualityDependenciesSensor.class);
    liste.add(PomQualityDependenciesDashboardWidget.class);
    liste.add(PomQualityDependenciesMavenPluginHandler.class);
    liste.add(PomQualityDependenciesMavenInitializer.class);
    return liste;
  }
  
  private PomQualityDependenciesUtils() {
  }
}
