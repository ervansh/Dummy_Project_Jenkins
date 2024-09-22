package com.jenkins.featurepages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePage() {
		@Nullable
		String title = driver.getTitle();
		System.out.println(title+" home page title.");
		if(title.equals("Google"))
			return true;
		return false;
	}
}
