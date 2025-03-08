package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class OrgnizationInformationPage {
	WebdriverUtlity wu=new WebdriverUtlity();
	WebDriver driver;
	public OrgnizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement orgnameinheader;
	@FindBy (xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgname;
	@FindBy(xpath = "//td[@id='mouseArea_Phone']")
	private WebElement phonenumber;
	@FindBy (xpath = "//span[@id='dtlview_Industry']")
	private WebElement industry;
	@FindBy (xpath = "//span[@id='dtlview_Type']")
	private WebElement type;
	@FindBy (xpath = "(//input[@title='Delete [Alt+D]'])[1]")
	private WebElement deleteicon;
	public WebElement getOrgnameinheader() {
		return orgnameinheader;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getPhonenumber() {
		return phonenumber;
	}
	public WebElement getIndustry() {
		return industry;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getDeleteicon() {
		return deleteicon;
	}
	
	

}
