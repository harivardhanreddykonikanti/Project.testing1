package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;
	public ProductInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath = "(//input[@name='Edit'])[1]")
	private WebElement editbtn;
	@FindBy (xpath = "//td[@id='mouseArea_Product Name']")
	private WebElement productname;
	@FindBy (xpath = "//span[@id='dtlview_Serial No']")
	private WebElement serialnumber;
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headertext;
	
	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSerialnumber() {
		return serialnumber;
	}

	public WebElement getHeadertext() {
		return headertext;
	}
	
	
	
	
	
	

}
