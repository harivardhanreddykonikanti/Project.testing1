package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoInformationPage {
	WebDriver driver;
	public ToDoInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//span[@class='lvtHeaderText']")
	private WebElement headertodoinfopage;

	public WebElement getHeadertodoinfopage() {
		return headertodoinfopage;
	}
	
	
	

}
