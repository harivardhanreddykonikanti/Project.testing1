package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidereg2 {
	@Test(dataProvider = "getdata")
	public void createcontact(String name,String orgname,long mno) {
		System.out.println("name is "+name+" orgnization name is "+orgname+" phone number is "+mno);
	}
	@DataProvider
	public Object[][] getdata(){
		Object[][] objarry=new Object[1][3];
		objarry[0][0]="harivardhan";
		objarry[0][1]="tekpyramid";
		objarry[0][2]=8523833772l;
		return objarry;
	}
	

}
