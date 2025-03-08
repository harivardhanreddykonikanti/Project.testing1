package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAndManagementPage {
	WebDriver driver;
	public UserAndManagementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//a[contains(text(),'Users')]")
	private WebElement usersicon;

	public WebElement getUsersicon() {
		return usersicon;
	}
	
	
	
	

}
