package com.serli.sonar.plugins.pomquality.dependencies.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.PersistenceMode;
import org.sonar.api.measures.PropertiesBuilder;

import com.serli.sonar.plugins.pomquality.AbstractPomQualityParser;
import com.serli.sonar.plugins.pomquality.dependencies.PomQualityDependenciesMetrics;
import com.serli.sonar.plugins.pomquality.dependencies.jaxb.Dependencies;

public class PomQualityDependenciesParser extends AbstractPomQualityParser<Dependencies> {

  private static Logger LOG = LoggerFactory.getLogger(PomQualityDependenciesParser.class);
  
//  public void parseReport(File xmlFile, final SensorContext context, Project project) {
//    org.sonar.api.resources.File pomFile = org.sonar.api.resources.File.fromIOFile(new File("pom.xml"), project);;
//
//    if (pomFile == null) {
//      pomFile = new org.sonar.api.resources.File("pom.xml");
//    }
//    Rule rule = Rule.create("maven-quality-plugin", "dependencyUsedAndDeclared", "Dependency used and declared");
//    
//    
//    LOG.info("parse report " + xmlFile.getPath());
//    try {
//      Dependencies dependenciesAnalysis = getDependenciesAnalysis(xmlFile, new Class[] { UndeclaredDependency.class, Dependencies.class});
//      
//      List<Measure> measures = getDependencyDeclarationMeasures(dependenciesAnalysis);
//      measures.addAll(getPotentialBugsMeasures(dependenciesAnalysis));
//      for (Measure measure : measures) {
//        context.saveMeasure(measure);
//      }
//      
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    } catch (JAXBException e) {
//      e.printStackTrace();
//    }
//  }
  
//  private Dependencies getDependenciesAnalysis(File file, Class... classToBeBound) throws JAXBException, FileNotFoundException {
//    JAXBContext jc = JAXBContext.newInstance(classToBeBound);
//    Unmarshaller unmarshaller = jc.createUnmarshaller();
//    InputStream resultDependenciesAnalysis = new FileInputStream(file);
//    
//    Dependencies conventions = (Dependencies) unmarshaller.unmarshal(resultDependenciesAnalysis);
//    return conventions;
//  }
  
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
    
//    CountDistributionBuilder builder = new CountDistributionBuilder(PomQualityDependenciesMetrics.DEPENDENCIES_DISTRIBUTION);
//    builder.add(usedDeclaredMeasure);
//    builder.add(unusedDeclaredMeasure);
    PropertiesBuilder<String, Double> dependenciesRepartition = new PropertiesBuilder<String, Double>(PomQualityDependenciesMetrics.DEPENDENCIES_DISTRIBUTION);
    addToRepartition(dependenciesRepartition, "unused", ((double)unusedDeclaredNumber / (double)total) * 100);
    addToRepartition(dependenciesRepartition, "used", ((double)usedDeclaredNumber / (double)total) * 100);
//    dependenciesRepartition.add(PomQualityDependenciesMetrics.DEPENDENCIES_UNUSED_DECLARED.getName(), (double)(unusedDeclaredNumber * 100)/(double) total);
//    dependenciesRepartition.add(PomQualityDependenciesMetrics.DEPENDENCIES_USED_DECLARED.getName(), (double)(usedDeclaredNumber * 100)/(double) total);
    
    
    measures.add(dependenciesRepartition.build().setPersistenceMode(PersistenceMode.MEMORY));
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
  
  private void addToRepartition(PropertiesBuilder<String, Double> dependenciesRepartition, String key, double value) {
    if (value > 0d) {
      // Math.floor is important to avoid getting very long doubles... see SONAR-859
      dependenciesRepartition.add(key, Math.floor(value * 100.0) / 100);
    }
  }

  @Override
  public List<Measure> getMeasures(Dependencies dependenciesAnalysis) {
    List<Measure> measures = getDependencyDeclarationMeasures(dependenciesAnalysis);
    measures.addAll(getPotentialBugsMeasures(dependenciesAnalysis));
    return measures;
  }
}
