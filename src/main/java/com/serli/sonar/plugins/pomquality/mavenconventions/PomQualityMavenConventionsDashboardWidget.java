package com.serli.sonar.plugins.pomquality.mavenconventions;

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Maven conventions compliance in POM File")
public class PomQualityMavenConventionsDashboardWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public String getId() {
    return "quality_maven_conventions";
  }

  public String getTitle() {
    return "Maven conventions compliance";
  }

  @Override
  protected String getTemplatePath() {
    return "/com/serli/sonar/plugins/pomquality/mavenconventions/quality_maven_conventions_dashboard_widget.html.erb";
  }
  
}