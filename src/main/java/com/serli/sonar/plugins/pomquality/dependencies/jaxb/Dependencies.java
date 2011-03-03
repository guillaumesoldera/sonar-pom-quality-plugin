package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dependencies {

  private List<DeclaredDependency> usedDeclared;

  private List<DeclaredDependency> unusedDeclared;
  
  private List<UndeclaredDependency> usedUndeclared;
  
  private List<MultipleDeclarationDependency> multipleDeclaration;
  
  private List<OverridingDependencyVersion> overridenVersions;
  
  private List<ExclusionDependency> exclusionErrors;
  
  @XmlElementWrapper(name = "usedDeclared")
  @XmlElement(name = "dependency")
  public List<DeclaredDependency> getUsedDeclared() {
    return usedDeclared;
  }

  public void setUsedDeclared(List<DeclaredDependency> usedDeclared) {
    this.usedDeclared = usedDeclared;
  }

  @XmlElementWrapper(name = "unusedDeclared")
  @XmlElement(name = "dependency")
  public List<DeclaredDependency> getUnusedDeclared() {
    return unusedDeclared;
  }

  public void setUnusedDeclared(List<DeclaredDependency> unusedDeclared) {
    this.unusedDeclared = unusedDeclared;
  }

  @XmlElementWrapper(name = "usedUndeclared")
  @XmlElement(name = "dependency")
  public List<UndeclaredDependency> getUsedUndeclared() {
    return usedUndeclared;
  }

  public void setUsedUndeclared(List<UndeclaredDependency> usedUndeclared) {
    this.usedUndeclared = usedUndeclared;
  }

  @XmlElementWrapper(name = "multipleDeclaration")
  @XmlElement(name = "dependency")
  public List<MultipleDeclarationDependency> getMultipleDeclaration() {
    return multipleDeclaration;
  }

  public void setMultipleDeclaration(List<MultipleDeclarationDependency> multipleDeclaration) {
    this.multipleDeclaration = multipleDeclaration;
  }

  @XmlElementWrapper(name = "overridenVersions")
  @XmlElement(name = "dependency")
  public List<OverridingDependencyVersion> getOverridenVersions() {
    return overridenVersions;
  }

  public void setOverridenVersions(List<OverridingDependencyVersion> overridenVersions) {
    this.overridenVersions = overridenVersions;
  }
  
  @XmlElementWrapper(name = "exclusionErrors")
  @XmlElement(name = "dependency")
  public List<ExclusionDependency> getExclusionErrors() {
    return exclusionErrors;
  }

  public void setExclusionErrors(List<ExclusionDependency> exclusionErrors) {
    this.exclusionErrors = exclusionErrors;
  }
  
}
