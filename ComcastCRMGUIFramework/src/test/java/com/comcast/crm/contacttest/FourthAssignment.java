package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.ContactsInformationPage;
import com.comcast.crm.objectRepository.ContactsPage;
import com.comcast.crm.objectRepository.CreateNewContactPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;


public class FourthAssignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//creating the object reference for the genric utilty
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		// step 1:reading data from property file
		FileUtility fu=new FileUtility();
		String url = fu.getDataFromPropertyFile("url");
		String browser = fu.getDataFromPropertyFile("browser");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		//step 2:reading properties from excel file 
		String value1 = eu.getDataFromExcel("contact", 1, 2);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String lastname = value1+rannumber;
		//step 4: login page
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		driver.get(url);
		lp.loginToapplication(username, password);
		//step 5: create new contact page
		hp.getContactslink().click();
		cp.getCreatecontactlink().click();
		cnp.getLastnametf().sendKeys(lastname);
		cnp.getSavebutton().click();
		//step 6: validtion of data in output page
		String lastnamevalid1 = cip.getContactnameheadertext().getText();
		String lastnamevalid2 = cip.getLastnamefied().getText();
		Thread.sleep(3000);
		wu.takescreenshotofpage(driver);
		String result1 = ju.containsChecks(lastnamevalid1,lastname);
		System.out.println(lastname+" is "+result1+" at the header page ");
		String lastnamevalid22 = lastnamevalid2.trim();
		String result2 = ju.equalsChecks(lastnamevalid22,lastname);
		System.out.println(lastname+" is "+result2+" entered into the website ");
		//step 7: logout from the page
		hp.logout();
		//step 8: closing of the browser 
		driver.quit();
		
	}

}
