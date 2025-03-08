package practice.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ConfigureAnnotationsTestig extends BaseClass {
	@Test
	public void configtesting() {
		System.out.println("this is method 1");
	}
	@Test
	public void configtesting2() {
		System.out.println("this is method 2");
	}

}
