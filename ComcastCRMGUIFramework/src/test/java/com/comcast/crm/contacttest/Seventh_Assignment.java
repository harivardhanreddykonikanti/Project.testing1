//create an orgination and delete it and go to the recycle bin and make it permenantly delete it
package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;
import com.comcast.crm.objectRepository.RecycleBinPage;

public class Seventh_Assignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		//loading common data from property files
		//initalizing objects for utlity classes
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		String url = fu.getDataFromPropertyFile("url");
		String browser = fu.getDataFromPropertyFile("browser");
		String password = fu.getDataFromPropertyFile("password");
		String username = fu.getDataFromPropertyFile("username");
		//loading TestScript data from exce
		String orgnam = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","seventh_assign", 1, 2);
		String dropvisibletext = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","seventh_assign", 1, 3);
		//mixing random number with orgname
		int rannumber = ju.getRandomNumber();		
		String orgname = orgnam+rannumber;
		//driver initlization
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		wu.waitPageToLoad(driver);
		driver.get(url);
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrgnizationPage op=new OrgnizationPage(driver);
		CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		RecycleBinPage rp=new RecycleBinPage(driver);
		//login to page
		lp.loginToVmTiger();
		//register new user using excel data
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		cnp.getOrgnizationfield().sendKeys(orgname);
		cnp.getSavebutton().click();
		//Verifying orginization name in the output
		String orgnameheader = oip.getOrgnameinheader().getText();
		String orgnamevalid = oip.getOrgname().getText();
		String result1 = ju.containsChecks(orgnameheader, orgname);
		System.out.println(orgname+" is "+result1+" at the header of the conformation page ==> passed");
		String result2 = ju.equalsChecks(orgnamevalid,orgname);
		System.out.println(orgname+ " is verifed "+result2+" at orgname text field ==> passed");
		//deleting the orgname
		oip.getDeleteicon().click();
		wu.switchToAlertsAccept(driver);
		//navigating to recycle bin
		Thread.sleep(3000);
		hp.recyclebin();
		Thread.sleep(3000);
		//recyclebin restoring 
		rp.getSearchfield().sendKeys(orgname);		
		rp.dropdown(dropvisibletext);
		rp.getSearchbutton().click();
		Thread.sleep(3000);
		//rp.dropdown("Organization Name");
		//***vvvvimp**** step****
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../preceding-sibling::td//input")).click();
		Thread.sleep(3000);
		rp.getEmprecyclebinbtn().click();
		rp.getPrementlydeleteyesbtn().click();
		Thread.sleep(5000);
		//verification for recycle bin
		rp.getSearchfield().sendKeys(orgname);		
		rp.dropdown(dropvisibletext);
		rp.getSearchbutton().click();
		String recyclebinmsg = rp.getSearchresultmsg().getText();
		String result3 = ju.containsChecks(recyclebinmsg,"No records found");
		System.out.println(orgname+"is removed from "+result3+" recycbin ");
		hp.logout();
		driver.close();
		
		
		
		
	}
	

}
