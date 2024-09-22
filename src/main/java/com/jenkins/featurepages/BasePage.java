package com.jenkins.featurepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy()
	private WebElement elementname;

	public WebElement getElementname() {
		return elementname;
	}

	public void setElementname(WebElement elementname) {
		this.elementname = elementname;
	}

}
