package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductInformationPage {
	WebDriver driver;
	public EditProductInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@id='serial_no']")
	private WebElement serialnumbertf;
	@FindBy (xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getSerialnumbertf() {
		return serialnumbertf;
	}
	
	
	
	
	
	

}
