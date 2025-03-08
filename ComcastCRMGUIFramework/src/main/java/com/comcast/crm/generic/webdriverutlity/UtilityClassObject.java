package com.comcast.crm.generic.webdriverutlity;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {// this class helps to share the static variable across multiple threads it helps in case of parellel execution
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}

}
