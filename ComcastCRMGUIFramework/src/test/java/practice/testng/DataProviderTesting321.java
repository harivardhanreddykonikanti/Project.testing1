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

public class DataProviderTesting321 {
	@DataProvider
	public Object[][] dataproviderfromexcel() throws EncryptedDocumentException, IOException{
		Object[][]arrobj=new Object[3][2];
		String path="/ComcastCRMGUIFramework/testdata/randomnumber.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int lastrownum=wb.getSheet("Sheet2").getLastRowNum();
		for(int i=0;i<lastrownum;i++) {
			arrobj[i][0]=wb.getSheet("Sheet2").getRow(i+1).getCell(0).toString();
			arrobj[i][1]=wb.getSheet("Sheet2").getRow(i+1).getCell(1).toString();
		}
		wb.close();
		return arrobj;		
		
		
	}
	@Test(dataProvider = "dataproviderfromexcel")
	public void shoes(String brand,String name) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brand,Keys.ENTER);
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//span[text()='"+name+"']/../../../../div[4]/div/div[1]/a/span")).getText();
		System.out.println("the price of the "+brand+" having shoes name "+name+ " is "+price);
	}

}
