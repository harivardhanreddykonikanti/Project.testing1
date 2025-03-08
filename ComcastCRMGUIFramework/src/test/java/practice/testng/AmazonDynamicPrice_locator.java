package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonDynamicPrice_locator {
	@Test
	public void getpriceofPhone() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("apple mobile",Keys.ENTER);
		String price = driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (512 GB) - Yellow']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span")).getText();
		Thread.sleep(3000);
		System.out.println("price of the apple mobile with yellow colour is "+price);
	}

}
