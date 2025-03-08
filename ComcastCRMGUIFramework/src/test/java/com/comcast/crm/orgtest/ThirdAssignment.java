package com.comcast.crm.orgtest;
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
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;


public class ThirdAssignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//creating object of the genric utlitys
		JavaUtility ju=new JavaUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		ExcelUtility eu=new ExcelUtility();
		// step 1:reading data from property file
		FileUtility fu=new FileUtility();
		String url = fu.getDataFromPropertyFile("url");
		String browser = fu.getDataFromPropertyFile("browser");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		//step 2:reading properties from excel file 
		String value1 = eu.getDataFromExcel("orgnization", 7, 2);
		String number = eu.getDataFromExcel("orgnization", 7, 3);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String orgnameinp = value1+rannumber;
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
		OrgnizationPage op=new OrgnizationPage(driver);
		CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		lp.loginToapplication(username, password);
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getPhonenumberfield().sendKeys(number);
		cnp.getSavebutton().click();
		//step 6: validtion of data in output page
		String orgnameoup = oip.getOrgnameinheader().getText();
		String orgnameoup2 = oip.getOrgname().getText();
		String result1 = ju.containsChecks(orgnameoup,orgnameinp);
		System.out.println(orgnameinp+" is "+result1+" at the header page");
		String result2 = ju.equalsChecks(orgnameoup2,orgnameinp);
		System.out.println(orgnameoup2+" is "+result2+" entered into the website");
		//validation for phone number
		String numberverif = oip.getPhonenumber().getText();
		String numberverify = numberverif.trim();
		String result3 = ju.equalsChecks(numberverify,number);
		System.out.println(number+" is "+result3+" at the output page ");
		//step 7: logout from the page
		hp.getSignoutlink();
		//step 8: closing of the browser 
		driver.quit();
		
	}

}

