package practice.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	@Test
	public void homepage(Method mdf) {
		System.out.println(mdf.getName());
		SoftAssert sa=new SoftAssert();
		System.out.println("step-1");
		sa.assertEquals("titles","title");
		System.out.println("step-2");
		Assert.assertEquals("home","homep");
		System.out.println("step-3");
		System.out.println("step-4");
		sa.assertAll();
	}

}
