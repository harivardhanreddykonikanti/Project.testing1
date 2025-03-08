package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
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
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;
import com.comcast.crm.objectRepository.OrgnizationSearchPage;


public class SixthAssignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//intizating object for the genric classes
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
		String value1 = eu.getDataFromExcel("contact", 7, 2);
		String acclastnam = eu.getDataFromExcel("contact", 7, 3);		
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String orgnameinp = value1+rannumber;
		String acclastname=acclastnam+rannumber;
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
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		OrgnizationSearchPage osp=new OrgnizationSearchPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		String parentid = driver.getWindowHandle();
		//step 5: create new registration
		lp.loginToapplication(username, password);
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getSavebutton().click();
		//step 5.7 creating new contact
		Thread.sleep(2000);
		hp.getContactslink().click();
		cp.createcontactlinkclick();
		ccp.getLastnametf().sendKeys(acclastname);
		ccp.getOrgplusicon().click();
		Set<String> allids = driver.getWindowHandles();
		wu.switchToBroswerTabOnUrl(driver,"Accounts&action");
		System.out.println(orgnameinp);
		//5.8 switching between windows 
		osp.getSearchfield().sendKeys(orgnameinp);
		osp.getSearchbutton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgnameinp+"']")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parentid);
		Thread.sleep(3000);
		ccp.getSavebutton().click();
		Thread.sleep(2000);
		
		//step 6: validtion of data in output page
		String orgnameoup = cip.getContactnameheadertext().getText();
		String orgnameoup2 = cip.getLastnamefied().getText();
		String result1 = ju.containsChecks(orgnameoup,acclastname);
		System.out.println(acclastname+" is "+result1+" the header of the page ");
		String orgnameoup22 = orgnameoup2.trim();
		String result2 = ju.equalsChecks(orgnameoup22,acclastname);
		System.out.println(acclastname+" is "+result2+" entered into website");
		//validation for organization name
		String orgnamevaild = cip.getOrgnizationnamearea().getText();
		String orgnamevaild2 = orgnamevaild.trim();
		String result3 = ju.equalsChecks(orgnamevaild2,orgnameinp);
		System.out.println(orgnamevaild2+" is "+result3+" at the output page ==> success");
		//step 7: logout from the page
		hp.getSignoutlink();
		//step 8: closing of the browser 
		Thread.sleep(3000);
		driver.quit();
		
	}

}

