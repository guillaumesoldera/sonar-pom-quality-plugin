package com.serli.sonar.plugins.pomquality.dependencies;

import org.sonar.api.measures.Metrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.CoreMetrics;

import java.util.List;
import java.util.Arrays;

public class PomQualityDependenciesMetrics implements Metrics {

  public static final Metric MESSAGE = new Metric("message_key", "Message",
    "This is a metric to store a well known message", Metric.ValueType.STRING, -1, false,
    CoreMetrics.DOMAIN_GENERAL);


  public static final Metric RANDOM = new Metric("random", "Random",
    "Random value", Metric.ValueType.FLOAT, Metric.DIRECTION_BETTER, false,
    CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric NB_DEPENDENCIES = new Metric("nbDependencies", "Dependencies number",
      "Dependencies number in POM file", Metric.ValueType.INT, Metric.DIRECTION_NONE, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric NB_POTENTIAL_BUGS_DEPENDENCIES = new Metric("nbPotentialBugsDependencies", "Potential bugs number",
      "Number of potential bugs in POM file", Metric.ValueType.INT, Metric.DIRECTION_NONE, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric DEPENDENCIES_USED_DECLARED = new Metric("dependenciesUsedDeclared", "Dependencies used and declared",
      "Dependencies used and declared in POM file", Metric.ValueType.INT, Metric.DIRECTION_NONE, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric DEPENDENCIES_USED_UNDECLARED = new Metric("dependenciesUsedUndeclared", "Dependencies used but undeclared",
      "Dependencies used but undeclared in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric DEPENDENCIES_UNUSED_DECLARED = new Metric("dependenciesUnusedDeclared", "Dependencies unused but declared",
      "Dependencies unused but declared in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric MULTIPLE_DECLARATION = new Metric("multipleDeclaration", "Dependencies declared many times",
      "Dependencies declared many times in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric OVERRIDEN_VERSIONS = new Metric("overridenVersions", "Overriden dependency version",
      "Dependency which override a dependencyManagement in POM file", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);

  public static final Metric EXCLUSION_ERRORS = new Metric("exclusionErrors", "Exclusions errors",
      "Dependency declared in POM file nut excluded in a dependencyManagement", Metric.ValueType.INT, Metric.DIRECTION_WORST, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  public static final Metric DEPENDENCIES_DISTRIBUTION = new Metric("depDistrib", "Dependencies distribution",
      "Distribution of dependencies in POM file", Metric.ValueType.DISTRIB, Metric.DIRECTION_NONE, false,
      CoreMetrics.DOMAIN_GENERAL);
  
  // getMetrics() method is defined in the Metrics interface and is used by
  // Sonar to retrieve the list of new Metric
  public List<Metric> getMetrics() {
    return Arrays.asList(NB_DEPENDENCIES, DEPENDENCIES_USED_DECLARED, DEPENDENCIES_UNUSED_DECLARED, DEPENDENCIES_USED_UNDECLARED, MULTIPLE_DECLARATION, OVERRIDEN_VERSIONS, EXCLUSION_ERRORS, DEPENDENCIES_DISTRIBUTION, NB_POTENTIAL_BUGS_DEPENDENCIES);
  }
  
  // TODO create metrics for maven convention, formatting convention, naming convention et dependance
  // metric pour le message
  // metric pour bug potentiel (multiple declaration (warning ?), exclusionsError et overridenVersion)
  
  
  // metric pour nombre de pb maven-convention
  
  // creer les rules
}
