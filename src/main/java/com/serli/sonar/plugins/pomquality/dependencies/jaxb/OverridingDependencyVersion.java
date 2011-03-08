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

  public final String getVersionDepMgt() {
    return versionDepMgt;
  }

  public final void setVersionDepMgt(String versionDepMgt) {
    this.versionDepMgt = versionDepMgt;
  }

  public final String getVersionResolved() {
    return versionResolved;
  }

  public final void setVersionResolved(String versionResolved) {
    this.versionResolved = versionResolved;
  }

  public final int getLineNumber() {
    return lineNumber;
  }

  public final void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }
  
}
