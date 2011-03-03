package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dependency")
public class ExclusionDependency {

  private String groupId;
  
  private String artifactId;
  
  private String versionFound;

  public ExclusionDependency() {
  }
  
  public ExclusionDependency(String groupId, String artifactId, String versionFound) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.versionFound = versionFound;
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

  public String getVersionFound() {
    return versionFound;
  }

  public void setVersionFound(String versionFound) {
    this.versionFound = versionFound;
  }
  
  
}
