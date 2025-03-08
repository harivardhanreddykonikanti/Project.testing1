package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationSearchPage {
	WebDriver driver;
	public OrgnizationSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchfield;
	@FindBy(xpath="//select[@name='search_field']")
	WebElement selectdrop;
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchbutton;
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getSelectdrop() {
		return selectdrop;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	

}
