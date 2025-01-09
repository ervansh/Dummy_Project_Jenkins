package com.jenkins.selenium.core.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedCases implements IRetryAnalyzer{

	int iretry = 0;
	int maxtry = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		while(iretry < maxtry) {
			System.out.println("Attempting retry."+iretry);
			iretry++;
			return true;
		}
		
		return false;
	}

}
