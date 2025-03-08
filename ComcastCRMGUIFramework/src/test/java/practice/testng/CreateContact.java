package practice.testng;

import java.io.IOException;
/**
 * @author harivardhan
 * test class for contact module
 */
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutlity.JavaUtility;
import com.comcast.crm.generic.webdriverutlity.UtilityClassObject;
import com.comcast.crm.generic.webdriverutlity.WebdriverUtlity;
import com.comcast.crm.objectRepository.ContactsInformationPage;
import com.comcast.crm.objectRepository.ContactsPage;
import com.comcast.crm.objectRepository.CreateNewContactPage;
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;
import com.comcast.crm.objectRepository.OrgnizationSearchPage;

public class CreateContact extends BaseClass{
	@Test(groups = "smoketest")
	public void createcontwithname() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel sheet");
		String value1 = eu.getDataFromExcel("contact", 1, 2);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String lastname = value1+rannumber;
		//step 4: login page
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		HomePage hp=new HomePage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		//step 5: create new contact page
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new contact link");
		hp.getContactslink().click();
		cp.getCreatecontactlink().click();
		cnp.getLastnametf().sendKeys(lastname);
		cnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"entered lastname and clicked on save button");
		//step 6: validtion of data in output page
		String lastnamevalid1 = cip.getContactnameheadertext().getText();
		String lastnamevalid2 = cip.getLastnamefied().getText();
		Thread.sleep(3000);
		wu.takescreenshotofpage(driver);
		boolean status = lastnamevalid1.contains(lastname);
		Assert.assertEquals(status,true);
		String lastnamevalid22 = lastnamevalid2.trim();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(lastnamevalid22, lastname);
		sa.assertAll();
		UtilityClassObject.getTest().log(Status.INFO,"lastname is successfully verifed at the contact information page");
	}
	@Test(groups = "regressiontest")
	public void createcontwithsuppdate() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel sheet");
		String value1 = eu.getDataFromExcel("contact", 4, 2);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String lastname = value1+rannumber;
		//step 4: login page
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		HomePage hp=new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new contact link");
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		//Step 4.8 capturing data and support date
		String actualdate = ju.getSystemData();
		
		//System.out.println(actualdate);
		// Step 4.9 support date for next 30 days adding to it
		String suppdate = ju.getRequiredDateyyyyMMdd(30);
		System.out.println(suppdate);		
		//step 5: create new contact page 
		hp.getContactslink().click();
		cp.createcontactlinkclick();
		cnp.getLastnametf().sendKeys(lastname);
		//step 5.9 adding dates into the respective fields
		Thread.sleep(2000);
		cnp.getStartdatefield().clear();
		cnp.getStartdatefield().sendKeys(actualdate);
		UtilityClassObject.getTest().log(Status.INFO,"entered system date into the field ");
		Thread.sleep(2000);
		cnp.getEnddatefield().clear();
		cnp.getEnddatefield().sendKeys(suppdate);
		UtilityClassObject.getTest().log(Status.INFO,"entered support date into the field");
		cnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the save button");
		//step 6: validtion of data in output page
		String lastnamevalid1 = cip.getContactnameheadertext().getText();
		String lastnamevalid2 = cip.getLastnamefied().getText();
		//step 6.1 validation of date in output page
		String expstartdate = cip.getStartdatefield().getText();
		String expsupportdate = cip.getEnddatefield().getText();
		boolean status = lastnamevalid1.contains(lastname);
		Assert.assertEquals(status,true);
		SoftAssert sa=new SoftAssert();
		String lastnamevalid22 = lastnamevalid2.trim();
		sa.assertEquals(lastnamevalid22, lastname);
		sa.assertEquals(expstartdate,actualdate);
		sa.assertEquals(expsupportdate,suppdate);
		sa.assertAll();
		UtilityClassObject.getTest().log(Status.INFO,"lastname along with todays date and supportive date is sucessfully verifed at the conformation page");
	}
	@Test(groups = "regressiontest")
	public void createcontwithorgname() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"entered support date into the field");
		String value1 = eu.getDataFromExcel("contact", 7, 2);
		String acclastnam = eu.getDataFromExcel("contact", 7, 3);		
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String orgnameinp = value1+rannumber;
		String acclastname=acclastnam+rannumber;
		//step 4: login page
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		HomePage hp=new HomePage(driver);
		OrgnizationPage op=new OrgnizationPage(driver);
		CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		OrgnizationSearchPage osp=new OrgnizationSearchPage(driver);
		ContactsInformationPage cip=new ContactsInformationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		String parentid = driver.getWindowHandle();
		//step 5: create new registration
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new orginzation page");
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		UtilityClassObject.getTest().log(Status.INFO,"entered name into the field");
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the save button");
		//step 5.7 creating new contact
		Thread.sleep(2000);
		hp.getContactslink().click();
		cp.createcontactlinkclick();
		ccp.getLastnametf().sendKeys(acclastname);
		UtilityClassObject.getTest().log(Status.INFO,"click on the orginzation link");
		ccp.getOrgplusicon().click();
		Set<String> allids = driver.getWindowHandles();
		wu.switchToBroswerTabOnUrl(driver,"Accounts&action");
		System.out.println(orgnameinp);
		//5.8 switching between windows 
		osp.getSearchfield().sendKeys(orgnameinp);
		osp.getSearchbutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the respective orgnization name");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgnameinp+"']")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parentid);
		Thread.sleep(3000);
		ccp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on the save button");
		Thread.sleep(2000);		
		//step 6: validtion of data in output page
		String orgnameoup = cip.getContactnameheadertext().getText();
		String orgnameoup2 = cip.getLastnamefied().getText();
		boolean status1 = orgnameoup.contains(acclastname);
		Assert.assertEquals(status1,true);
		String orgnameoup22 = orgnameoup2.trim();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(orgnameoup22,acclastname);
		//validation for organization name
		String orgnamevaild = cip.getOrgnizationnamearea().getText();
		String orgnamevaild2 = orgnamevaild.trim();
		sa.assertEquals(orgnamevaild2,orgnameinp);
		UtilityClassObject.getTest().log(Status.INFO,"contact name long with respective orgnization is succesfully verified");
		}
}
