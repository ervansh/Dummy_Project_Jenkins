package com.jenkins.featuretest;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.jenkins.selenium.core.browserhandler.BrowserstackFactory;
import com.jenkins.selenium.core.browserhandler.DriverManager;
import com.jenkins.selenium.core.utils.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	boolean useBrowserStack = false;
	String google = "https://www.google.com/";
	String saucedemo = "https://www.saucedemo.com/";
	ConfigReader config;

	public BaseTest() {
		config = new ConfigReader("config.properties");
	}

	@BeforeClass
	public void setUpDriver() {
		String browser = config.getPropertyValue("browser");
		System.out.println(browser+" Browser ??");
		System.out.println("Setup AUT.");
		if(useBrowserStack) {
			driver = BrowserstackFactory.createBrowserstackDriver();
		} else {
		driver = DriverManager.getBrowserInstance(browser);
		 }

		driver.get(saucedemo);
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

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public boolean isElementDisplayed(WebElement locator) throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2000));
		return locator.isDisplayed();
	}

	public boolean verifyPageTitle(String textToVerify) {
		@Nullable
		String title = driver.getTitle();
		System.out.println(title + " home page title.");
		if (title.equals(textToVerify))
			return true;
		return false;
	}
}
