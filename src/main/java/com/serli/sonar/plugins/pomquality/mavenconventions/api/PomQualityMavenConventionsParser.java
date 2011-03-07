package com.serli.sonar.plugins.pomquality.mavenconventions.api;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.measures.Measure;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityParser;
import com.serli.sonar.plugins.pomquality.mavenconventions.PomQualityMavenConventionsMetrics;
import com.serli.sonar.plugins.pomquality.mavenconventions.jaxb.MavenConventionsViolation;

public class PomQualityMavenConventionsParser extends AbstractPomQualityParser<MavenConventionsViolation> {

  @Override
  public List<Measure> getMeasures(MavenConventionsViolation report) {
    List<Measure> measures = new ArrayList<Measure>();
    int formattingViolationsNumber = report.getFormattingViolations().size();
    int namingViolationsNumber = report.getNamingViolations().size();
    int total = formattingViolationsNumber + namingViolationsNumber;
    measures.add(new Measure(PomQualityMavenConventionsMetrics.NB_VIOLATIONS, (double)total));
    measures.add(new Measure(PomQualityMavenConventionsMetrics.NB_FORMATTING_VIOLATIONS, (double)formattingViolationsNumber));
    measures.add(new Measure(PomQualityMavenConventionsMetrics.NB_NAMING_VIOLATIONS, (double)namingViolationsNumber));
    return measures;
  }

}
