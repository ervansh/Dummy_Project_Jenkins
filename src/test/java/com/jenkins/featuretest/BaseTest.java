package com.jenkins.featuretest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.jenkins.selenium.core.browserhandler.BrowserFactory;

public class BaseTest {

	public static WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setUpDriver(String browser) {
		driver = BrowserFactory.getDriver(browser).createDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Duration time = driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().pageLoadTimeout(time);
	}

	@BeforeMethod
	public void setUpBeforeMethod() {
		System.out.println("Setup before method.");
	}

	@BeforeMethod
	public void setUpAfterMethod() {
		System.out.println("Setup after method.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
