 package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//input[@name='productname']")
	private WebElement productnametf;
	@FindBy (xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;

	
	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getProductnametf() {
		return productnametf;
	}
	
}
