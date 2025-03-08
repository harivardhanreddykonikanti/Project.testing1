package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * @author harivardhan
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnametf;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgplusicon;
	@FindBy(xpath = "(//input[contains(@title,'Save')])[1]")
	private WebElement savebutton;
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startdatefield;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement enddatefield;
	public WebElement getLastnametf() {
		return lastnametf;
	}
	public WebElement getStartdatefield() {
		return startdatefield;
	}
	public WebElement getEnddatefield() {
		return enddatefield;
	}
	public WebElement getOrgplusicon() {
		return orgplusicon;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	

}
