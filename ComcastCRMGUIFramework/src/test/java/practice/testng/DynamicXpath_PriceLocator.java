package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicXpath_PriceLocator {
	@Test
	public void getdynamicprice() throws InterruptedException {
		WebDriver  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("apple watch",Keys.ENTER);
		String price=driver.findElement(By.xpath("//a[text()='Apple Watch Series 10 GPS + Cellular 42mm Silver Alumin...']/..//a[2]/div//div")).getText();
		System.out.println("price of the watch is "+price);	
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void getdynamiciphoneprice() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("applemoblie",Keys.ENTER);
		String price2 = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Ultramarine, 128 GB)']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println("price of the apple mobile is "+price2);
		
	}

}
