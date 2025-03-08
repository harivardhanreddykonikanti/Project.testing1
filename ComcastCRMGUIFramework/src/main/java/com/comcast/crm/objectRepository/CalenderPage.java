package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * @author harivardhan
 * this page consists add button save button todo button
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class CalenderPage {
	WebdriverUtlity wu=new WebdriverUtlity();
	WebDriver driver;
	public CalenderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@id='addtodo']")
	private WebElement todobutton;
	
	@FindBy (xpath = "//td[@class='calAddButton']")
	private WebElement addbtn;
	@FindBy (xpath = "//input[@name='task_subject']")
	private WebElement todotextfield;
	@FindBy (xpath = "//textarea[@name='task_description']")
	private WebElement tododescription;
	@FindBy (xpath = "//input[@name='todosave']")
	private WebElement todosavebtn;
	
	
	
	
	public WebElement getTodosavebtn() {
		return todosavebtn;
	}
	public WebElement getTododescription() {
		return tododescription;
	}
	public WebElement getTodotextfield() {
		return todotextfield;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}
	
	public WebElement getTodobutton() {
		return todobutton;
	}
	/**
	 * this method helps us to click createtodo 
	 */

	public void createtodo() {
		wu.moveOnToTheElement(driver, addbtn);	
		todobutton.click();
	}
	

}
