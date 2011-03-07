package com.serli.sonar.plugins.pomquality.mavenconventions.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mavenConventionsViolation")
public class MavenConventionsViolation {

  private List<Violation> formattingViolations;
  
  private List<Violation> namingViolations;
  
  public MavenConventionsViolation() {
  }

  @XmlElementWrapper(name = "formattingViolations")
  @XmlElement(name = "violation")
  public List<Violation> getFormattingViolations() {
    return formattingViolations;
  }

  public void setFormattingViolations(List<Violation> formattingViolations) {
    this.formattingViolations = formattingViolations;
  }

  @XmlElementWrapper(name = "namingViolations")
  @XmlElement(name = "violation")
  public List<Violation> getNamingViolations() {
    return namingViolations;
  }

  public void setNamingViolations(List<Violation> namingViolations) {
    this.namingViolations = namingViolations;
  }
  
  
}
