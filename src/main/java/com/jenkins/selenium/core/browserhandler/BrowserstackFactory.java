package com.jenkins.selenium.core.browserhandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jenkins.selenium.core.utils.YamlReader;

public class BrowserstackFactory {
	
	private Platform platform; 

	private static String browserStackUsername = "vanshrajsingh_kdNDX1";
	private static String browserStackAccessKey = "41UvqXwdQeqdxRdsZn1h";
	private static String browserStackURL = "http://" + browserStackUsername + ":" + browserStackAccessKey
			+ "@hub.browserstack.com/wd/hub";
	
	

	private BrowserstackFactory(Platform platform) {
		this.platform = platform;
	}



	public static WebDriver createBrowserstackDriver() {
		BrowserStackConfig config = new YamlReader().getBroserstackConfig();
		
		MutableCapabilities capabilities = new MutableCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");  // ChromeOptions for starting chrome in incognito mode

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		// other capability declarations
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		capabilities.setCapability("bstack:options", browserstackOptions);

		try {
			return new RemoteWebDriver(new URL(browserStackURL), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException("BrowserStack URL is invalid", e);
		}
	}

}
