package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AttachScreenShotToReport {
	@Test
	public void attachScToReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReporting/report.html");
		spark.config().setDocumentTitle("CRM reporting");
		spark.config().setReportName("CRM File test");
		spark.config().setTheme(Theme.DARK);
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser","chrome");
		report.setSystemInfo("operating system","windows-11");
		ExtentTest test = report.createTest("attachScToReport");
		test.log(Status.INFO,"login to the app");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("hdf".equals("hdfc")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
			test.addScreenCaptureFromBase64String(filepath,"errorfile");
		}
		report.flush();
	}

}
