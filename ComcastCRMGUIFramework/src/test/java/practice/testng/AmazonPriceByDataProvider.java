package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonPriceByDataProvider {
	@DataProvider 
	public Object[][] dataproviderphonedata() {
		Object[][] objarry=new Object[3][2];
		objarry[0][0]="samsung fold";
		objarry[0][1]="Samsung Galaxy Z Fold6 5G AI Smartphone (Pink, 12GB RAM, 256GB Storage)";
		objarry[1][0]="apple mobile";
		objarry[1][1]="Apple iPhone 15 (512 GB) - Yellow";
		objarry[2][0]="realme 14 pro";
		objarry[2][1]="realme 14 pro+ (Pearl White, 12GB RAM + 256GB Storage)";
		return objarry;		
	}
	@Test (dataProvider = "dataproviderphonedata")
	public void getpriceofelements(String brand,String name) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brand,Keys.ENTER);
		String price = driver.findElement(By.xpath("//span[text()='"+name+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span")).getText();
		Thread.sleep(3000);
		System.out.println("price of the"+brand+" having "+name+" is "+price);
		
	}

}
