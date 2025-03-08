package practice.testng;

import org.testng.annotations.Test;

public class TestNgPractice1 {
	@Test(invocationCount = 5)
	public void createorg() {
		System.out.println("creating orgnization in the webpage ");
	}
	@Test(enabled = false)
	public void createcontact() {
		System.out.println("contact contact with orgnization name");
	}
	

}
