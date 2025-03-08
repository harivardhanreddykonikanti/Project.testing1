package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * @author harivardhan
 * it contains elements like settingsicon,calenderlink
 * organization link and contact link
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class HomePage {
	WebDriver driver;
	WebdriverUtlity wu=new WebdriverUtlity();
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingicon;
	@FindBy(xpath = "(//a[@class='drop_down_usersettings'])[5]")
	private WebElement crmsettings;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement orgnizationlink;
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactslink;
	@FindBy(xpath = "(//a[contains(text(),'More')])[1]")
	private WebElement morelink;
	@FindBy(xpath ="//a[@name='Recycle Bin']")
	private WebElement recyclebinlink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountimg;
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	private WebElement signoutlink;
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calenderlink;
	@FindBy(xpath = "(//a[text()='Products'])[1]")
	private WebElement productslink;
	
	
	
	
	
	public WebElement getProductslink() {
		return productslink;
	}
	public WebElement getCrmsettings() {
		return crmsettings;
	}
	public WebElement getSettingicon() {
		return settingicon;
	}
	public WebElement getCalenderlink() {
		return calenderlink;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgnizationlink() {
		return orgnizationlink;
	}
	public WebElement getContactslink() {
		return contactslink;
	}
	public WebElement getMorelink() {
		return morelink;
	}
	public WebElement getRecyclebinlink() {
		return recyclebinlink;
	}
	public WebElement getAccountimg() {
		return accountimg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	/**
	 * logout method helps to logout of the crm site
	 */
	public void logout() {
		wu.moveOnToTheElement(driver, accountimg);
		signoutlink.click();
	}
	/**
	 * this method helps us to go to recycle bin page
	 */
	public void recyclebin() {
		wu.moveOnToTheElement(driver,morelink);
		recyclebinlink.click();		
	}
	/**
	 * this method will help us to goto the settings page
	 */
	public void crmsetting() {
		wu.moveOnToTheElement(driver,settingicon);
		crmsettings.click();
	}
	
	

}
