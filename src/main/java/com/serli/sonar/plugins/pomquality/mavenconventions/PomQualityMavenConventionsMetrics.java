package com.serli.sonar.plugins.pomquality.mavenconventions;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

public class PomQualityMavenConventionsMetrics implements Metrics {

  public static final Metric NB_FORMATTING_VIOLATIONS = new Metric("nb-formatting-violations", "Formatting violations number",
      "Formatting violations number in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric NB_NAMING_VIOLATIONS = new Metric("nb-naming-violations", "Naming violations number",
      "Naming violations number in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric NB_VIOLATIONS = new Metric("nb-maven-convention-violations", "Maven convention violations number",
      "Total number of maven convention violations in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  
  public List<Metric> getMetrics() {
    return Arrays.asList(NB_FORMATTING_VIOLATIONS, NB_NAMING_VIOLATIONS, NB_VIOLATIONS);
  }

}
