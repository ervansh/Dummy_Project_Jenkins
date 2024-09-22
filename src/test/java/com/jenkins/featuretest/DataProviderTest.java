package com.jenkins.featuretest;

import org.testng.annotations.Test;

import com.jenkins.selenium.core.utils.TestDataProvider;

public class DataProviderTest {

	
	@Test(dataProvider = "getStringData", dataProviderClass = TestDataProvider.class)
	public void testData(String str1, String str2) {
		System.out.println(str1 + " " + str2);
	}
}
