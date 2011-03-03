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


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }
  
  
}
