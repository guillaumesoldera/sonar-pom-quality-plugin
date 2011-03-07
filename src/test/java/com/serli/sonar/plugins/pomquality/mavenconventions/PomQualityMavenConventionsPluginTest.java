package com.serli.sonar.plugins.pomquality.mavenconventions;

import static org.hamcrest.number.OrderingComparisons.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.serli.sonar.plugins.pomquality.PomQualityPlugin;



public class PomQualityMavenConventionsPluginTest {
  
  @Test
  public void pomQualityExtensions() {
    assertThat(new PomQualityPlugin().getExtensions().size(), greaterThan(1));
  }
}
