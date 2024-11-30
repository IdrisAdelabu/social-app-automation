package com.gbadegesin.socialappautomation.cucumberRunners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
//With this SelectClasspathResource
@SelectClasspathResource("com/gbadegesin/socialappautomation/pageFeatures/registerPage.feature")
@SelectClasspathResource("com/gbadegesin/socialappautomation/pageFeatures/loginPage.feature")
@SelectClasspathResource("com/gbadegesin/socialappautomation/pageFeatures/feedPage.feature")
@SelectClasspathResource("com/gbadegesin/socialappautomation/pageFeatures/profilePage.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.bptn.feedAppAutomation")
public class RunCucumberTest {
}