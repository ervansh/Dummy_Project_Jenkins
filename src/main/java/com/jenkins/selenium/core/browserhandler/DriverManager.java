package com.jenkins.selenium.core.browserhandler;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static WebDriver driver = null;

	private DriverManager() {
	}

	public static WebDriver getBrowserInstance(String browserType) {

		if (driver == null) {
			driver = BrowserFactory.getDriver(browserType).createDriver();
		}
		return driver;
	}
	
	public static void closeBrowserInstance() {
		if(driver != null) {
			driver.close();
		}
	}
	
}
