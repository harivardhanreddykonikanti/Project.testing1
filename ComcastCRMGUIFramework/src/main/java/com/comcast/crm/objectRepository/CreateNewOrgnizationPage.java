package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgnizationPage {
	WebDriver driver;
	public CreateNewOrgnizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgnizationfield;
	@FindBy(id = "phone" )
	private WebElement phonenumberfield;
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industrydrop;
	@FindBy (xpath = "//select[@name='accounttype']")
	private WebElement typedrop;
	@FindBy (xpath = "(//input[@name='button'])[1]")
	private WebElement  savebutton;
	public WebElement getOrgnizationfield() {
		return orgnizationfield;
	}
	public WebElement getPhonenumberfield() {
		return phonenumberfield;
	}
	public WebElement getIndustrydrop() {
		return industrydrop;
	}
	public WebElement getTypedrop() {
		return typedrop;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	

}
