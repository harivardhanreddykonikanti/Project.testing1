//creating new user and verifiying at the conformation page
package com.comcast.crm.contacttest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
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
import com.comcast.crm.objectRepository.CreateNewUserPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.SettingsUserPage;
import com.comcast.crm.objectRepository.UserAndManagementPage;

public class Ninth_Assignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		//loading common data from property files
		//initalizing objects for utlity classes
				FileUtility fu=new FileUtility();
				JavaUtility ju=new JavaUtility();
				ExcelUtility eu=new ExcelUtility();
				WebdriverUtlity wu=new WebdriverUtlity();
				String url = fu.getDataFromPropertyFile("url");
				String browser = fu.getDataFromPropertyFile("browser");
		//System.out.println(url);
		//loading TestScript data from excel
		String usernam = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 2);
		String upassword = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 3);
		String ucpassword = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 4);
		String email = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 5);
		String lastname = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 6);
		String role = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Ninth_assign", 1, 7);
		//System.out.println(role)	
		int randomint = ju.getRandomNumber();
		String username1 = usernam+randomint;
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
				wu.maximizeBrowser(driver);
				wu.waitPageToLoad(driver);
				LoginPage lp=new LoginPage(driver);
				HomePage hp=new HomePage(driver);
				UserAndManagementPage up=new UserAndManagementPage(driver);
				SettingsUserPage sup=new SettingsUserPage(driver);
				CreateNewUserPage cnup=new CreateNewUserPage(driver);
				
				//login to page
				lp.loginToVmTiger();
				//navigating to the settings page
				hp.crmsetting();				
				//navigating to user settings
				Thread.sleep(2000);
				up.getUsersicon().click();				
				Thread.sleep(2000);
				sup.getNewuserbtn().click();
				String parentid = driver.getWindowHandle();
				//entering data into new user fields
				cnup.getUsername().sendKeys(username1);
				cnup.getPassword().sendKeys(upassword);
				cnup.getConformpassword().sendKeys(ucpassword);
				cnup.getEmail().sendKeys(email);
				cnup.getLastname().sendKeys(lastname);
				cnup.getRoleicon().click();
				Set<String> allids = driver.getWindowHandles();
				for(String id:allids) {
					driver.switchTo().window(id);
					if(driver.getCurrentUrl().contains("RolePopup")) {
						driver.findElement(By.xpath("//a[text()='"+role+"']")).click();
					}
				}
				driver.switchTo().window(parentid);
				cnup.getSavebtn().click();
				//verification of new user
				System.out.println("username1"+username1);
				List<WebElement> names = driver.findElements(By.xpath("//td[contains(@class,'TableRow')]"));
				boolean flag=false;
				for(WebElement name:names) {
					if(name.getText().contains(username1)) {
						flag=true;
					}
					
				}
				if(flag==true) {
					System.out.println(username1+" is successfully verified at conformation page ==> success");
				}
				else {
					System.out.println(username1+" is not verified at conformation page ==> failed");
				}
				hp.logout();
				driver.close();
				
				
	}}

