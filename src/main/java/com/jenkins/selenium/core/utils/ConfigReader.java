package com.jenkins.selenium.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader(String configFilePath) {
		prop = new Properties();
		try {
			FileInputStream inputstream = new FileInputStream(configFilePath);
			prop.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getProp() {
		return prop;
	}
	
	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

}
