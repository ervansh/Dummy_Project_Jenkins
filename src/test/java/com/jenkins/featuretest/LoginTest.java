package com.jenkins.featuretest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jenkins.featurepages.HomePage;

public class LoginTest extends BaseTest {

	HomePage homepage;

	@Test
	public void isHomePageDisplayed() {
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.isHomePage());
	}

}
