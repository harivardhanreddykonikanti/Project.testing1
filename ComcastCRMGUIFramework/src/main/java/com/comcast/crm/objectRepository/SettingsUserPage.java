package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsUserPage {
	WebDriver driver;
	public SettingsUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//input[contains(@class,'crmButton')]")
	private WebElement newuserbtn;

	public WebElement getNewuserbtn() {
		return newuserbtn;
	}
	
	
	
	

}
