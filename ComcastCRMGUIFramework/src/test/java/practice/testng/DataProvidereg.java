package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidereg {
	@Test(dataProvider = "getdata")
	public void createcontact(String conname,String orgname) {
		System.out.println("contact name is "+conname+" orgname is "+orgname);
	}
	@DataProvider
	public Object[][] getdata(){
		Object[][] objarry=new Object[3][2];
		objarry[0][0]="harivardhan";
		objarry[0][1]="tekpyramid";
		objarry[1][0]="ramu";
		objarry[1][1]="testyantra";
		objarry[2][0]="shyam";
		objarry[2][1]="q spiders";
		return objarry;
	}

}
