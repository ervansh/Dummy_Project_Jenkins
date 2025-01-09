package com.jenkins.featurepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
