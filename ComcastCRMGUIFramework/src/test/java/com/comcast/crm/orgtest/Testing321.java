package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;

public class Testing321 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapplication("admin", "admin");
		HomePage hp=new HomePage(driver);
		hp.getOrgnizationlink().click();
		Thread.sleep(2000);
		hp.recyclebin();
		hp.logout();
	}

}
