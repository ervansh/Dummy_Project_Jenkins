package com.jenkins.selenium.core.browserhandler;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserManager implements IDriver {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	@Override
	public void quitDriver() {
		//createDriver().quit();
	}

	@Override
	public void browserOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setImplicitWaitTimeout(Duration.ofSeconds(5));

	}

}
