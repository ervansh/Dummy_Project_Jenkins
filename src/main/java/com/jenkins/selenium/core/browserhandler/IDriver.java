package com.jenkins.selenium.core.browserhandler;

import org.openqa.selenium.WebDriver;

public interface IDriver {
	public WebDriver createDriver();
	public void browserOptions();
	public void quitDriver();
}
