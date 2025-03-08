package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonSamsungDynamicPrice {
	@Test 
	public void samsungprice() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung fold",Keys.ENTER);
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//span[text()='Samsung Galaxy Z Flip5 (Mint, 8GB RAM, 512GB Storage) Without Offer']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span")).getText();
		System.out.println("the price of the mobile is "+price);
	}

}
