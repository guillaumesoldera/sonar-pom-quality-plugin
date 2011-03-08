package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dependency")
public class DeclaredDependency {

  private String groupId; 
  
  private String artifactId; 
  
  private String version;
  
  private int lineNumber;
  
  public DeclaredDependency() {
  }

  public DeclaredDependency(String groupId, String artifactId, String version, int lineNumber) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
    this.lineNumber = lineNumber;
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

  public final String getVersion() {
    return version;
  }

  public final void setVersion(String version) {
    this.version = version;
  }

  public final int getLineNumber() {
    return lineNumber;
  }

  public final void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }
  
}
