package com.serli.sonar.plugins.pomquality.mavenconventions.api;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;

import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsDashboardWidget;
import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsMavenInitializer;
import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsMavenPluginHandler;
import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsMetrics;
import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsSensor;

public final class PomQualityMavenConventionsUtils {

  public static List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> liste = new ArrayList<Class<? extends Extension>>();
    liste.add(PomQualityMavenConventionsMetrics.class);
    liste.add(PomQualityMavenConventionsSensor.class);
    liste.add(PomQualityMavenConventionsMavenInitializer.class);
    liste.add(PomQualityMavenConventionsMavenPluginHandler.class);
    liste.add(PomQualityMavenConventionsDashboardWidget.class);
    return liste;
  }
  
  private PomQualityMavenConventionsUtils() {
  }
}
