//create a product and edit the product and add serial number and save it and  check it is displaying properly or not 
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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.CreatingNewProductPage;
import com.comcast.crm.objectRepository.EditProductInformationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.ProductInformationPage;
import com.comcast.crm.objectRepository.ProductsPage;

public class Tenth_assignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		//loading common data from property files
		//initalizing objects for utlity classes
				FileUtility fu=new FileUtility();
				JavaUtility ju=new JavaUtility();
				ExcelUtility eu=new ExcelUtility();
				WebdriverUtlity wu=new WebdriverUtlity();
				String url = fu.getDataFromPropertyFile("url");
				String browser = fu.getDataFromPropertyFile("browser");
				//loading TestScript data from excel
				String productnam = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Tenth_assign", 1, 2);
				String serialnum = eu.getDataFromExcel("./testdata/ExcelFor7to10.xlsx","Tenth_assign", 1, 3);
		//mixing random number with orgname
				int rannumber = ju.getRandomNumber();
				String productname = productnam+rannumber;
				String serialnumber = serialnum+rannumber;
		//System.out.println(serialnumber);
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
		ProductsPage pp=new ProductsPage(driver);
		CreatingNewProductPage cnpp=new CreatingNewProductPage(driver);
		ProductInformationPage pip=new ProductInformationPage(driver);
		EditProductInformationPage epip=new EditProductInformationPage(driver);
		//login to page
		lp.loginToVmTiger();
		//System.out.println(productname);
		//creating product using excel data
		hp.getProductslink().click();
		pp.getCreatenewproductlink().click();
		cnpp.getProductnametf().sendKeys(productname);
		cnpp.getSavebtn().click();
		//editing the data and adding serial number into it
		pip.getEditbtn().click();
		epip.getSerialnumbertf().sendKeys(serialnumber);
		epip.getSavebtn().click();
		 //verification process 
		String pronameverif1 = pip.getProductname().getText();
		String serialveri = pip.getSerialnumber().getText();
		String pronaeverif2 = pip.getHeadertext().getText();
		String result1 = ju.containsChecks(pronaeverif2,productname);
		System.out.println(productname+" is verified " +result1+" at header ");
		String result2 = ju.equalsChecks(pronameverif1.trim(),productname);				
		System.out.println(productname+" is verified "+result2);
		String result3 = ju.equalsChecks(serialveri,serialnumber);
		System.out.println(serialnumber+" is verified "+result3);
		//step 7: logout from the page
		 hp.logout();
			//step 8: closing of the browser 
			driver.quit();
			
		 
				
	}

}
