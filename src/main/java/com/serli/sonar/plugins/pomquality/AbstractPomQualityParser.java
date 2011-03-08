package com.serli.sonar.plugins.pomquality;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;

public abstract class AbstractPomQualityParser<T> {

  private static Logger log = LoggerFactory.getLogger(AbstractPomQualityParser.class);

  public void parseReport(File xmlFile, final SensorContext context, Class... classToBeBound) {
//    org.sonar.api.resources.File pomFile = org.sonar.api.resources.File.fromIOFile(new File("pom.xml"), project);
//    ;
//
//    if (pomFile == null) {
//      pomFile = new org.sonar.api.resources.File("pom.xml");
//    }
//    context.index(pomFile);
//    Rule rule = Rule.create("maven-quality-plugin", "dependencyUsedAndDeclared", "Dependency used and declared");

    log.info("parse report " + xmlFile.getPath());
    try {
      T resultAnalysis = getResultAnalysis(xmlFile, classToBeBound);

      List<Measure> measures = getMeasures(resultAnalysis);
     
      for (Measure measure : measures) {
        context.saveMeasure(measure);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      log.error(e.getMessage(), e);
    } catch (JAXBException e) {
      log.error(e.getMessage(), e);
    }
  }

  private T getResultAnalysis(File file, Class... classToBeBound) throws JAXBException, FileNotFoundException {
    JAXBContext jc = JAXBContext.newInstance(classToBeBound);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    InputStream resultDependenciesAnalysis = new FileInputStream(file);

    return (T) unmarshaller.unmarshal(resultDependenciesAnalysis);
  }

  public abstract List<Measure> getMeasures(T report);
}
