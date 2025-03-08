package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class RecycleBinPage {
	WebdriverUtlity wu=new WebdriverUtlity();
	WebDriver driver;
	public RecycleBinPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "bas_searchfield")
	private WebElement dropdown;
	@FindBy(xpath = "//input[@name='search_text']")
	WebElement searchfield;
	@FindBy(xpath = "//input[@name='submit']")
	WebElement searchbutton;
	@FindBy(xpath = "(//input[@onclick='callEmptyRecyclebin();'])[1]")
	private WebElement emprecyclebinbtn;
	@FindBy(xpath = "//input[@type='button' and @value='Yes']")
	WebElement prementlydeleteyesbtn;
	@FindBy (xpath = "//span[@class='genHeaderSmall']")
	private WebElement searchresultmsg;
	
	public WebElement getSearchresultmsg() {
		return searchresultmsg;
	}
	public WebElement getPrementlydeleteyesbtn() {
		return prementlydeleteyesbtn;
	}
	public WebElement getEmprecyclebinbtn() {
		return emprecyclebinbtn;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public void dropdown(String visibletext) {
		wu.selectByVisibleText(visibletext, dropdown);
	}

}
