package com.serli.sonar.plugins.pomquality;

import static org.hamcrest.number.OrderingComparisons.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;



public class PomQualityPluginTest {
  
  @Test
  public void pomQualityExtensions() {
    assertThat(new PomQualityPlugin().getExtensions().size(), greaterThan(1));
  }
}
