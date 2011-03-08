package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dependency")
public class UndeclaredDependency {

  private String groupId; 
  
  private String artifactId; 
  
  private String version;
  
  public UndeclaredDependency() {
  }

  public UndeclaredDependency(String groupId, String artifactId, String version) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
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
  
  
}
