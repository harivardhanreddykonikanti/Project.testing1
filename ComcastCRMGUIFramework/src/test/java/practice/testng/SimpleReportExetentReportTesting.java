package practice.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SimpleReportExetentReportTesting {
	@Test
	public void extentreporttest() {
		//spark report configration
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReporting/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//adding enviorment information and create test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);		
		report.setSystemInfo("OS","windows-11");
		report.setSystemInfo("browser","chrome");
		ExtentTest test = report.createTest("extentreporttest");//*		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navaigate to contact page");
		test.log(Status.INFO,"create contact page");
		if("hdfc".equals("hdfc")) {
			test.log(Status.PASS,"the contact is created successfully");
		}
		else {
			test.log(Status.FAIL,"the contact is not create falied");
		}
		report.flush();
	}

}
