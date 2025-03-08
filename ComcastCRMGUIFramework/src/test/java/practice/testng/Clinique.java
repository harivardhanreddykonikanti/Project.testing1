package practice.testng;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clinique {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.clinique.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']")).click();
		//Thread.sleep(15000);
		//driver.findElement(By.xpath(""))
		//driver.findElement(By.xpath("//button[@id='dismissBtn']")).click();
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));
		action.moveToElement(ele).build().perform();
		List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),'Hand')]/../a"));
		for(WebElement element:elements) {
			System.out.println(element.getText());
		}
		
		
	}

}
