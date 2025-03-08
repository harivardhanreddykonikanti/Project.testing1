package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUserPage {
	WebDriver driver;
	public CreateNewUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "//input[@name='user_name']")
	private WebElement username;
	@FindBy (xpath = "//input[@name='user_password']")
	private WebElement password;
	@FindBy (xpath = "//input[@name='confirm_password']")
	private WebElement conformpassword;
	@FindBy (xpath = "//input[@name='email1']")
	private WebElement email;
	@FindBy (xpath = "//input[@id='role_name']/following-sibling::a")
	private WebElement roleicon;
	@FindBy (xpath = "//input[@name='last_name']")
	private WebElement lastname;
	@FindBy (xpath = "(//input[contains(@title,'Save')])[1]")
	private WebElement savebtn;
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConformpassword() {
		return conformpassword;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getRoleicon() {
		return roleicon;
	}
	
	
	

}
