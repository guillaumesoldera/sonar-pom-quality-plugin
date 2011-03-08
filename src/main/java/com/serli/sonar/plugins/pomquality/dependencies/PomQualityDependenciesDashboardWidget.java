package com.serli.sonar.plugins.pomquality.dependencies;

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Quality of dependencies declaration in POM File")
public class PomQualityDependenciesDashboardWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public String getId() {
    return "quality_dependencies";
  }

  public String getTitle() {
    return "Maven dependencies declaration";
  }

  @Override
  protected String getTemplatePath() {
    return "/com/serli/sonar/plugins/pomquality/dependencies/quality_dependencies_dashboard_widget.html.erb";
  }
  
}