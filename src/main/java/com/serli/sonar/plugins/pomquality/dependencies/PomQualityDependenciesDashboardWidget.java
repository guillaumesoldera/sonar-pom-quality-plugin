package com.serli.sonar.plugins.pomquality.dependencies;

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Quality of dependencies declaration in POM File")
@WidgetProperties({
        @WidgetProperty(key="param1",
                        description="This is a mandatory parameter",
                        optional=false
        ),
        @WidgetProperty(key="max",
                        description="max threshold",
                        type=WidgetPropertyType.INTEGER,
                        defaultValue="80"
        ),
        @WidgetProperty(key="param2",
                        description="This is an optional parameter"
        ),
        @WidgetProperty(key="floatprop",
                        description="test description"
        )
})
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