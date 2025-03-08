package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * @author harivardhan
 * this method constist of orgnization name and many
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	WebDriver driver;
	public ContactsInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//td[contains(@id,'mouseArea_Organization')]")
	private WebElement orgnizationnamearea;
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement contactnameheadertext;
	@FindBy (xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement lastnamefied;
	@FindBy (xpath = "(//span[contains(@id,'dtlview_Support')])[1]")
	private WebElement startdatefield;
	@FindBy (xpath = "(//span[contains(@id,'dtlview_Support')])[2]")
	private WebElement enddatefield;
	public WebElement getContactnameheadertext() {
		return contactnameheadertext;
	}
	public WebElement getOrgnizationnamearea() {
		return orgnizationnamearea;
	}
	public WebElement getLastnamefied() {
		return lastnamefied;
	}
	public WebElement getStartdatefield() {
		return startdatefield;
	}
	public WebElement getEnddatefield() {
		return enddatefield;
	}
	
	

}
