 package practice.testng;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicPathThroughExcel {
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("E:\\ComcastCRMGUIFramework\\testdata\\ExcelForDataProvider.xlsx");
		Object[][] objarry=new Object[3][2];
		Workbook wb = WorkbookFactory.create(fis);
		int lastrownum2 = wb.getSheet("Sheet2").getLastRowNum();
		System.out.println(lastrownum2);
		int lastrownum = wb.getSheet("Sheet2").getLastRowNum();
		System.out.println("lastrownum is "+lastrownum);
		for(int i=0;i<3;i++) {	
			System.out.println(wb.getSheet("Sheet2").getRow(i+1).getCell(0).toString());
			System.out.println(wb.getSheet("Sheet2").getRow(i+1).getCell(1).toString());
			
			objarry[i][0]=wb.getSheet("Sheet2").getRow(i+1).getCell(0).toString();
			objarry[i][1]=wb.getSheet("Sheet2").getRow(i+1).getCell(1).toString();
		}
		wb.close();
		return objarry;		
	}
@Test (dataProvider = "getdata")
public void getpriceofelements(String brand,String name) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brand,Keys.ENTER);
	String price = driver.findElement(By.xpath("//span[text()='"+name+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span")).getText();
	Thread.sleep(3000);
	System.out.println("price of the"+brand+" having "+name+" is "+price);
	
}
}
