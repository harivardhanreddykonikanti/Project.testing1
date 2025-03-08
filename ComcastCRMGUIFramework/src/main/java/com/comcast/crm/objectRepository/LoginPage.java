package com.comcast.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
/**
 * @author harivardhan
 * contains login page element like username and password textfields
 */

public class LoginPage extends WebdriverUtlity {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "user_name")
	private WebElement username;
	@FindBy(name ="user_password")
	private WebElement password;
	@FindBy(id ="submitButton")
	private WebElement submit;
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmit() {
		return submit;
	}
	//provide actions or business library
	/**
	 *@author harivardhan 
	 * @param username
	 * @param password
	 */
	public void loginToapplication(String userna,String pass) {
		username.sendKeys(userna);
		password.sendKeys(pass);
		submit.click();		
	}
	public void loginToVmTiger() {
		waitPageToLoad(driver);
		username.sendKeys("admin");
		password.sendKeys("admin");
		submit.click(); 
	}
	

}
