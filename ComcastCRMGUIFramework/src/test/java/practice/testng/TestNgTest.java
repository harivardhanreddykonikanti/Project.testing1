package practice.testng;

import org.testng.annotations.Test;

public class TestNgTest {
	@Test(invocationCount = 5)
	public void b() {
		System.out.println("executed B");
	}
	@Test(enabled = false)
	public void a() {
		System.out.println("excecuted A");
	}
	

}
