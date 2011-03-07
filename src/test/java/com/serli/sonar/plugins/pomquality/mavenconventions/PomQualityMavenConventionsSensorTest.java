package com.serli.sonar.plugins.pomquality.mavenconventions;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.test.IsMeasure;

public class PomQualityMavenConventionsSensorTest {

  @Test
  public void verifyResultOfParseAndMeasuresSaved() {
    System.out.println("TODO verifyResultOfParseAndMeasuresSaved");
  }
  
  @Test
  public void shouldSavedTotalMavenConventionViolation() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityMavenConventionsSensor().parseReport(getMavenConventionsReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityMavenConventionsMetrics.NB_VIOLATIONS, 9.0)));
  }

  @Test
  public void shouldSavedFormattingConventionViolation() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityMavenConventionsSensor().parseReport(getMavenConventionsReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityMavenConventionsMetrics.NB_FORMATTING_VIOLATIONS, 6.0)));
  }
  
  @Test
  public void shouldSavedNamingConventionViolation() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityMavenConventionsSensor().parseReport(getMavenConventionsReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityMavenConventionsMetrics.NB_NAMING_VIOLATIONS, 3.0)));
  }
  
  private File getMavenConventionsReport() throws URISyntaxException {
    return new File(getClass().getResource("/com/serli/sonar/plugins/pomquality/PomQualitySensorTest/maven-conventions-check.xml").toURI());
  }
}
