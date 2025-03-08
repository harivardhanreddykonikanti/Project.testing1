package com.comcast.crm.basetest;


import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.UtilityClassObject;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public WebdriverUtlity wu=new WebdriverUtlity();
	public ExcelUtility eu=new ExcelUtility();		
	public DataBaseUtility db=new DataBaseUtility();
	public JsonUtility js=new JsonUtility();
	
	
	@BeforeSuite(groups = {"smoketest","regressiontest"})
	public void configBeforeSuit() throws Throwable {
		//System.out.println("before suit method");
		System.out.println("connected to database and report config");
		db.getDbconnection();
	}
	@AfterSuite(groups = {"smoketest","regressiontest"})
	public void configAftersuit() {
		//System.out.println("this is after suite");
		System.out.println("connection to the data base has been closed");
		db.closeDbConnection();
	}
	@BeforeMethod(groups = {"smoketest","regressiontest"})
	public void configbeforemethod() throws IOException {
		//System.out.println("this is before method");
		LoginPage lp=new LoginPage(driver);
		String url = fu.getDataFromPropertyFile("url");
		driver.get(url);
		lp.loginToVmTiger();
		
		//System.out.println("login to the website");
	}
	@AfterMethod(groups = {"smoketest","regressiontest"})
	public void configaftermethod() {
		//System.out.println("this is after method");
		HomePage hp=new HomePage(driver);
		hp.logout();
	//	System.out.println("logout from the website");
	}
	//@Parameters("browser")
	@BeforeClass(groups = {"smoketest","regressiontest"})
	public void configbeforeclass() throws Throwable {
		//System.out.println("this is before class ");
		String url = fu.getDataFromPropertyFile("url");
		//String bro = browser;		
		String bro=fu.getDataFromPropertyFile("browser");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		if(bro.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		//driver.get(url);
		
		//System.out.println("Launch the browser");
	}
	@AfterClass(groups = {"smoketest","regressiontest"})
	public void configafterclass() {
		//System.out.println("this is after class ");
		driver.quit();
		//System.out.println("close the browser");
	}

}
