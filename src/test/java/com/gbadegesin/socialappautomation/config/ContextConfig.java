package com.gbadegesin.socialappautomation.config;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.gbadegesin.socialappautomation.SocialAppAutomationApplication;

import io.cucumber.spring.CucumberContextConfiguration;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = SocialAppAutomationApplication.class)
public class ContextConfig {
	
}