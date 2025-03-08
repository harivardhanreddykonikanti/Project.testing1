package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * @author harivardhan
 * this method consists of createcontact link
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactlink;
	
	public WebElement getCreatecontactlink() {
		return createcontactlink;
	}
	/**
	 * this method helps us to naviagate to creat contact page
	 */
	public void createcontactlinkclick() {
		getCreatecontactlink().click();
	}
	

}
