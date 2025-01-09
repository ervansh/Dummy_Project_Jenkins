package com.jenkins.featuretest;

import java.util.Properties;

import org.testng.annotations.Test;

import com.jenkins.selenium.core.utils.ConfigReader;

public class ReadData {

	@Test(enabled = true)
	public void dataread() {
		ConfigReader config = new ConfigReader("config.properties");
	Properties prop = config.getProp();
	String time = prop.getProperty("timeOut");
	System.out.println(time+" ??");
	
	
	}
	
	
}
