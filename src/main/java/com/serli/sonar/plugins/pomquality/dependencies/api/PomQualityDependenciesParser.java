package com.serli.sonar.plugins.pomquality.dependencies.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.CountDistributionBuilder;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.PersistenceMode;
import org.sonar.api.rules.Rule;

import com.serli.sonar.plugins.pomquality.PomQualityUtils;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMetrics;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.Dependencies;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.UndeclaredDependency;

public class PomQualityDependenciesParser {

  private static Logger LOG = LoggerFactory.getLogger(PomQualityDependenciesParser.class);
  
  public void parseReport(File xmlFile, final SensorContext context) {
    Rule rule = Rule.create("maven-quality-plugin", "dependencyUsedAndDeclared", "Dependency used and declared");
    LOG.info("parse report " + xmlFile.getPath());
    try {
      Dependencies dependenciesAnalysis = getDependenciesAnalysis(xmlFile);
      
      List<Measure> measures = getDependencyDeclarationMeasures(dependenciesAnalysis);
      measures.addAll(getPotentialBugsMeasures(dependenciesAnalysis));
      for (Measure measure : measures) {
        context.saveMeasure(measure);
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
  
  private Dependencies getDependenciesAnalysis(File file) throws JAXBException, FileNotFoundException {
    JAXBContext jc = JAXBContext.newInstance(new Class[] { UndeclaredDependency.class, Dependencies.class});
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    InputStream resultDependenciesAnalysis = new FileInputStream(file);
    
    Dependencies conventions = (Dependencies) unmarshaller.unmarshal(resultDependenciesAnalysis);
    return conventions;
  }
  
  private List<Measure> getDependencyDeclarationMeasures(Dependencies dependenciesAnalysis) {
    List<Measure> measures = new ArrayList<Measure>();
    int unusedDeclaredNumber = dependenciesAnalysis.getUnusedDeclared().size();
    int usedDeclaredNumber = dependenciesAnalysis.getUsedDeclared().size();
    int usedUndeclaredNumber = dependenciesAnalysis.getUsedUndeclared().size();
    int total = usedDeclaredNumber + unusedDeclaredNumber;
    measures.add(new Measure(PomQualityDependenciesMetrics.NB_DEPENDENCIES, (double)total));
    Measure unusedDeclaredMeasure = new Measure(PomQualityDependenciesMetrics.DEPENDENCIES_UNUSED_DECLARED,  (double) unusedDeclaredNumber);
    Measure usedDeclaredMeasure = new Measure(PomQualityDependenciesMetrics.DEPENDENCIES_USED_DECLARED, (double) usedDeclaredNumber);
    Measure usedUndeclaredMeasure = new Measure(PomQualityDependenciesMetrics.DEPENDENCIES_USED_UNDECLARED, (double) usedUndeclaredNumber);
    measures.add(unusedDeclaredMeasure);
    measures.add(usedDeclaredMeasure);
    measures.add(usedUndeclaredMeasure);
    
    CountDistributionBuilder builder = new CountDistributionBuilder(PomQualityDependenciesMetrics.DEPENDENCIES_DISTRIBUTION);
    builder.add(usedDeclaredMeasure);
    builder.add(unusedDeclaredMeasure);
    measures.add(builder.build().setPersistenceMode(PersistenceMode.MEMORY));
    return measures;
  }
  
  private List<Measure> getPotentialBugsMeasures(Dependencies dependenciesAnalysis) {
    List<Measure> measures = new ArrayList<Measure>();
    int multipleDeclarationNumber = dependenciesAnalysis.getMultipleDeclaration().size();
    int overridenVersionsNumber = dependenciesAnalysis.getOverridenVersions().size();
    int exclusionErrorsNumber = dependenciesAnalysis.getExclusionErrors().size();

    Measure multipleDeclarationMeasure = new Measure(PomQualityDependenciesMetrics.MULTIPLE_DECLARATION, (double) multipleDeclarationNumber);
    Measure overridenVersionMeasure = new Measure(PomQualityDependenciesMetrics.OVERRIDEN_VERSIONS, (double) overridenVersionsNumber);
    Measure exclusionErrorsMeasure = new Measure(PomQualityDependenciesMetrics.EXCLUSION_ERRORS, (double) exclusionErrorsNumber);
    
    Measure potentialBugsMeasure = new Measure(PomQualityDependenciesMetrics.NB_POTENTIAL_BUGS_DEPENDENCIES, (double) (multipleDeclarationNumber + overridenVersionsNumber + exclusionErrorsNumber));
    
    measures.add(multipleDeclarationMeasure);
    measures.add(overridenVersionMeasure);
    measures.add(exclusionErrorsMeasure);
    measures.add(potentialBugsMeasure);
    return measures;
  }
  
  private double getAverage(int number, int total) {
    return (double)(number * 100) / (double) total;
  }
}
