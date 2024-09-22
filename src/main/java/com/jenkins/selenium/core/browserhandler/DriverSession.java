package com.jenkins.selenium.core.browserhandler;

import org.openqa.selenium.WebDriver;

public class DriverSession {

	private static ThreadLocal<WebDriver> currentsession = new ThreadLocal<>();
	private static ThreadLocal<String> currentmachinename = new ThreadLocal<>();
	
	
	private DriverSession() {
		super();
	}

	public static WebDriver getCurrentSession() {
		return currentsession.get();
	}

	public static void setCurrentSession(WebDriver newSession) {
		currentsession.set(newSession);
	}

	public static String getCurrentMachineName() {
		return currentmachinename.get();
	}
	
	public static void resetSession() {
		currentsession.remove();
	}
}
