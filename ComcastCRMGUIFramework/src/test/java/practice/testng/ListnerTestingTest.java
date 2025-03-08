package practice.testng;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

//@Listeners(com.comcast.crm.listenerutility.ListnerimplementaionClass.class)
public class ListnerTestingTest extends BaseClass {
	@Test 
	public void createinvoice() {
		System.out.println("execuite createinvoice");
		String acctitle = driver.getTitle();
		Assert.assertEquals(acctitle,"hari");//  i want to take screen shot here because it is failed here then we have to use listener class 
		System.out.println("step=1");
		System.out.println("step=2");
		System.out.println("step=3");
		System.out.println("step=4");
		
	}
	@Test
	public void createinvoicewithcontact() {
		System.out.println("execuite create invoice with contact");
		System.out.println("step=1");
		System.out.println("step=2");
		System.out.println("step=3");
		System.out.println("step=4");
		
		
	}

}
