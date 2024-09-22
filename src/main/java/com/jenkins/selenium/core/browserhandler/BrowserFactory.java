package com.jenkins.selenium.core.browserhandler;

public class BrowserFactory {
	public static IDriver getDriver(String browserType) {
		switch (browserType.toLowerCase()) {
		case "chrome":
			return new ChromeBrowserManager();
		case "firefox":
			return new FirefoxBrowserManager();
		default:
			throw new IllegalArgumentException("Enter a valid browser.");
		}
	}
}
