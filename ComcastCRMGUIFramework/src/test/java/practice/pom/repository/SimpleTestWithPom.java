package practice.pom.repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;

public class SimpleTestWithPom {
	@FindBy (name = "user_name")
	WebElement element1;
	@FindBy (name = "user_password")
	WebElement element2;
	@FindBy (xpath = "//input[@type='submit']")
	WebElement element3;
	@Test
	public void simpletest() throws IOException, InterruptedException {
		FileUtility fu=new FileUtility();
		WebdriverUtlity wu=new WebdriverUtlity();
		WebDriver driver=new ChromeDriver();		
		String url = fu.getDataFromPropertyFile("url");
		driver.get(url);
		wu.waitPageToLoad(driver);
		SimpleTestWithPom s = PageFactory.initElements(driver,SimpleTestWithPom.class);
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		Thread.sleep(3000);
		driver.navigate().refresh();
		s.element1.sendKeys(username);
		s.element2.sendKeys(password);
		s.element3.click();
		
	}

}
