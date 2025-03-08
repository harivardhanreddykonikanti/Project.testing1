package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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


public class FifthAssignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//creating object for the genric classes
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		// step 1:reading data from property file
		FileUtility fu=new FileUtility();
		String browser = fu.getDataFromPropertyFile("browser");
		String url = fu.getDataFromPropertyFile("url");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		//step 2:reading properties from excel file 		
		String value1 = eu.getDataFromExcel("contact", 4, 2);
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
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		lp.loginToapplication(username, password);
		//Step 4.8 capturing data and support date
		String actualdate = ju.getSystemData();
		//System.out.println(actualdate);
		// Step 4.9 support date for next 30 days adding to it
		String suppdate = ju.getRequiredDateyyyyMMdd(30);
		System.out.println(suppdate);		
		//step 5: create new contact page 
		hp.getContactslink().click();
		cp.createcontactlinkclick();
		cnp.getLastnametf().sendKeys(lastname);
		//step 5.9 adding dates into the respective fields
		Thread.sleep(2000);
		cnp.getStartdatefield().clear();
		cnp.getStartdatefield().sendKeys(actualdate);
		Thread.sleep(2000);
		cnp.getEnddatefield().clear();
		cnp.getEnddatefield().sendKeys(suppdate);
		cnp.getSavebutton().click();
		//step 6: validtion of data in output page
		String lastnamevalid1 = cip.getContactnameheadertext().getText();
		String lastnamevalid2 = cip.getLastnamefied().getText();
		//step 6.1 validation of date in output page
		String expstartdate = cip.getStartdatefield().getText();
		String expsupportdate = cip.getEnddatefield().getText();
		String result1 = ju.containsChecks(lastnamevalid1,lastname);
		System.out.println(lastname+" is "+result1+" at the header page ");
		String lastnamevalid22 = lastnamevalid2.trim();
		String result2 = ju.equalsChecks(lastnamevalid22,lastname);
		System.out.println(lastname+" is "+result2+" into the website ");
		String result3 = ju.equalsChecks(expstartdate,actualdate);
		System.out.println("Start date is "+result3+" matched");
		String result4 = ju.equalsChecks(expsupportdate,suppdate);
		System.out.println("expiry date is "+result4+" matched");
		//step 7: logout from the page
		hp.logout();
		//step 8: closing of the browser 
		Thread.sleep(3000);
		driver.quit();
		
	}

}
