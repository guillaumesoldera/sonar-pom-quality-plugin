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



  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
