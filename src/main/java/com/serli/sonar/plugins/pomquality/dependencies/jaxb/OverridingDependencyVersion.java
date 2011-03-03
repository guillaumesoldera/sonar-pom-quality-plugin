package com.serli.sonar.plugins.pomquality.dependencies.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dependency")
public class OverridingDependencyVersion {

  private String groupId;
  
  private String artifactId;
  
  private String versionDepMgt;
  
  private String versionResolved;
  
  private int lineNumber;

  public OverridingDependencyVersion() {
  }
  
  public OverridingDependencyVersion(String groupId, String artifactId, String versionDepMgt, String versionResolved, int lineNumber) {
    super();
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.versionDepMgt = versionDepMgt;
    this.versionResolved = versionResolved;
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

  public String getVersionDepMgt() {
    return versionDepMgt;
  }

  public void setVersionDepMgt(String versionDepMgt) {
    this.versionDepMgt = versionDepMgt;
  }

  public String getVersionResolved() {
    return versionResolved;
  }

  public void setVersionResolved(String versionResolved) {
    this.versionResolved = versionResolved;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }
  
}
