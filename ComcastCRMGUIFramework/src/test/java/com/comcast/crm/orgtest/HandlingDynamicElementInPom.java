package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;

//go to the organization page and create an orgnization and save it and delete it using dynamic locators(always use driver.findelementby)

public class HandlingDynamicElementInPom {
	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		JavaUtility ju=new JavaUtility();
		String browser = fu.getDataFromPropertyFile("browser");
		String url = fu.getDataFromPropertyFile("url");
		WebDriver driver;
		if(browser.contains("chrome")) {
			driver=new ChromeDriver();			
		}
		else {
			driver=new EdgeDriver();
		}
		driver.get(url);
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		//creating objects for pom
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrgnizationPage op=new OrgnizationPage(driver);
		CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		
		lp.loginToVmTiger();
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		String orgname = eu.getDataFromExcel("E:\\ComcastCRMGUIFramework\\testdata\\ExcelFor10Assignments.xlsx","ForDynamicElement", 1, 2);
		int randomnum = ju.getRandomNumber();
		String orgnameinp = orgname+randomnum;
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getSavebutton().click();
		Thread.sleep(2000);
		hp.getOrgnizationlink().click();
		op.getSearchfield().sendKeys(orgnameinp);
		String droporgnameactual = eu.getDataFromExcel("E:\\ComcastCRMGUIFramework\\testdata\\ExcelFor10Assignments.xlsx","ForDynamicElement", 1, 3);
		op.orgdropdown(droporgnameactual);
		op.getSearchbutton().click();
		driver.findElement(By.xpath("//a[text()='"+orgnameinp+"' and @title='Organizations']/../..//a[text()='del']")).click();//This is the way we are going to handle dynamic elements in the real time bcz dynamic elements are not able to hadle in the pom so we use driver.find element here
		wu.switchToAlertsAccept(driver);
		hp.logout();
		driver.close();
		
		
		
		
		
		
	}
	
	

}
