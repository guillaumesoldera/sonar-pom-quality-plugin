package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dependency")
public class MultipleDeclarationDependency {

  private String groupId;
  
  private String artifactId;
  
  private List<Integer> declarations;

  public MultipleDeclarationDependency() {
  }
  
  public MultipleDeclarationDependency(String groupId, String artifactId, List<Integer> declarations) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.declarations = declarations;
  }

  public final String getGroupId() {
    return groupId;
  }

  public final void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public final String getArtifactId() {
    return artifactId;
  }

  public final void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  @XmlElementWrapper(name = "declarations")
  @XmlElement(name = "declarationLine")
  public final List<Integer> getDeclarations() {
    return declarations;
  }

  public final void setDeclarations(List<Integer> declarations) {
    this.declarations = declarations;
  }
  
  
}
