package practice.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLog {
	@Test
	public void reportlogtest() {
		System.out.println("test 1");// this is only avaliable in console
		System.out.println("test 2");
		Reporter.log("test 3");// this will be avalible in the html report
		Reporter.log("test 4");
		Reporter.log("test 5",true);// these are avaliable in both console and html report
		Reporter.log("test 6",true);
		
	}

}
