//go to the calender and make todo list and check it is visible or not 
package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.objectRepository.CalenderPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.ToDoInformationPage;

public class Eight_Assignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		//loading common data from property files
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		String url = fu.getDataFromPropertyFile("url");
		String browser = fu.getDataFromPropertyFile("browser");
		//loading TestScript data from excel
		String tod = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","eight_assign", 1, 2);
		String description = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","eight_assign", 1, 3);
		int randomint = ju.getRandomNumber();
		String todo = tod+randomint;
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
				CalenderPage cp=new CalenderPage(driver);
				ToDoInformationPage tip= new ToDoInformationPage(driver);
				
				//login to page
				lp.loginToVmTiger();
				//calender function starts
				hp.getCalenderlink().click();
				cp.createtodo();	
				cp.getTodotextfield().sendKeys(todo);
				cp.getTododescription().sendKeys(description);
				cp.getTodosavebtn().click();
				//verifiying item
				List<WebElement> alltodolists = driver.findElements(By.xpath("//a[@class='webMnu']"));
				for(WebElement todolist:alltodolists) {
					if(todolist.getText().equals(todo)) {
						todolist.click();
						}
				}
				String verifytodoname =tip.getHeadertodoinfopage().getText();
				String result1 = ju.containsChecks(verifytodoname,todo);
				System.out.println("the name is "+result1+" at the conformation page ");
				hp.logout();
				driver.close();
				
				
		
	}
}



