package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class OrgnizationPage {
	WebdriverUtlity wu=new WebdriverUtlity();
	WebDriver driver;
	public OrgnizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createorgilink;

	public WebElement getCreateorgilink() {
		return createorgilink;
	}
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchfield;
	@FindBy(id = "bas_searchfield")
	private WebElement searchdropdown;
	@FindBy(xpath = "(//input[contains(@value,' Search')])[1]")
	private WebElement searchbutton;
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getSearchdropdown() {
		return searchdropdown;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public void orgdropdown(String visibletext) {
		wu.selectByVisibleText(visibletext, searchdropdown);
	}
	
	

}
