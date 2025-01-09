package com.jenkins.selenium.core.browserhandler;

import java.util.List;

public class BrowserStackConfig {

	private String userName;
	private String accessKey;
	private List<Platform> platforms;

	public String getUserName() {
		return userName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public List<Platform> getPlatforms() {
		return platforms;
	}

}
