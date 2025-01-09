package com.jenkins.featuretest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jenkins.featurepages.HomePage;

public class LoginTest extends BaseTest {

	HomePage homepage;
	//ConfigReader config;

	@Test
	public void isHomePageDisplayed() {
		homepage = new HomePage(driver);
		homepage.getUsername().sendKeys("standard_user");

		Assert.assertTrue(homepage.getBtnLogin().isDisplayed());
	}

}
