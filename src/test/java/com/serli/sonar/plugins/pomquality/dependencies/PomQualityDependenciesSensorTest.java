package com.serli.sonar.plugins.pomquality.dependencies;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.test.IsMeasure;

public class PomQualityDependenciesSensorTest {

  @Test
  public void shouldSavedTotalDependencies() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.NB_DEPENDENCIES, 18.0)));
  }
  
  @Test
  public void shouldSavedUsedAndDeclaredDependencies() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.DEPENDENCIES_USED_DECLARED, 8.0)));
  }
  
  @Test
  public void shouldSavedUnusedButDeclaredDependencies() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.DEPENDENCIES_UNUSED_DECLARED, 10.0)));
  }
  
  @Test
  public void shouldSavedUusedButUndeclaredDependencies() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.DEPENDENCIES_USED_UNDECLARED, 2.0)));
  }
  
  @Test
  public void shouldSavedPotentielBugNumberInDependenciesDeclaration() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.NB_POTENTIAL_BUGS_DEPENDENCIES, 2.0)));
  }

  @Test
  public void shouldSavedMultipleDeclarationBug() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.MULTIPLE_DECLARATION, 1.0)));
  }

  @Test
  public void shouldSavedOverridenVersionsBug() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.OVERRIDEN_VERSIONS, 1.0)));
  }

  @Test
  public void shouldSavedExclusionsErrorBug() throws URISyntaxException {
    SensorContext context = mock(SensorContext.class);
    new PomQualityDependenciesSensor().parseReport(getDependenciesAnalyzeReport(), context);

    verify(context).saveMeasure(argThat(new IsMeasure(PomQualityDependenciesMetrics.EXCLUSION_ERRORS, 0.0)));
  }
  
  private File getDependenciesAnalyzeReport() throws URISyntaxException {
    return new File(getClass().getResource("/com/serli/sonar/plugins/pomquality/PomQualitySensorTest/dependencies-analysis.xml").toURI());
  }
}
