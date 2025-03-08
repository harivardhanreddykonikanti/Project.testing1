package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyiserTesting {
	@Test(retryAnalyzer =practice.testng.RetryListnerImplementation.class)
	public void activatesim() {
		System.out.println("execuite createinvoice");
		Assert.assertEquals("","Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
