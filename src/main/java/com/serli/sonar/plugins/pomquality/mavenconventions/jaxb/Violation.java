package com.serli.sonar.plugins.pomquality.mavenconventions.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="violation")
public class Violation {

  private String tag;
  
  private int line;
  
  private String message;
  
  public Violation() {
  }
  
  public Violation(String tag, int line, String message) {
    super();
    this.tag = tag;
    this.line = line;
    this.message = message;
  }



  public final String getTag() {
    return tag;
  }

  public final void setTag(String tag) {
    this.tag = tag;
  }

  public final int getLine() {
    return line;
  }

  public final void setLine(int line) {
    this.line = line;
  }

  public final String getMessage() {
    return message;
  }

  public final void setMessage(String message) {
    this.message = message;
  }
}
