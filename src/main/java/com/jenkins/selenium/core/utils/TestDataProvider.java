package com.jenkins.selenium.core.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "getStringData")
	public Object[][] getStringData() {
		return new Object[][] {
			{"Name", "Vansh"},
			{"Design", "Sr"},
			{"Dept", "Testing"}
		};
	}
}
