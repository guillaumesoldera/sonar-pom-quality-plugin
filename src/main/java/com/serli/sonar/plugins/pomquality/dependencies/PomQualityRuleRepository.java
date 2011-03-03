package com.serli.sonar.plugins.pomquality.dependencies;

import java.util.List;

import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;

public class PomQualityRuleRepository extends RuleRepository {

  protected PomQualityRuleRepository(String key, String language) {
    super(PomQualityUtils.REPOSITORY_KEY, language);
  }

  @Override
  public List<Rule> createRules() {
    // TODO Auto-generated method stub
    return null;
  }

}
