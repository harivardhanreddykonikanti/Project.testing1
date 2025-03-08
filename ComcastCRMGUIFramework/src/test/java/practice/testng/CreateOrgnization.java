package practice.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.comcast.crm.objectRepository.CreateNewOrgnizationPage;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.objectRepository.OrgnizationInformationPage;
import com.comcast.crm.objectRepository.OrgnizationPage;

public class CreateOrgnization extends BaseClass {
	@Test (groups = "smoketest")
	public void createContactTest() throws InterruptedException, EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel sheet");
		String value1 = eu.getDataFromExcel("orgnization", 1, 2);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String orgnameinp = value1+rannumber;
		//step 4: login page
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		OrgnizationPage op=new OrgnizationPage(driver);
		HomePage hp=new HomePage(driver);
		CreateNewOrgnizationPage cnp= new CreateNewOrgnizationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		//step 5: create new registration 
		UtilityClassObject.getTest().log(Status.INFO,"entered into the home page");
		hp.getOrgnizationlink().click();
		UtilityClassObject.getTest().log(Status.INFO,"entered into orgnization page");
		op.getCreateorgilink().click();	
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"entered all details and clicked on submit button");
		//step 6: validtion of data in output page
		String orgnameoup = oip.getOrgnameinheader().getText();
		String orgnameoup2 = oip.getOrgname().getText();
		boolean status = orgnameoup2.contains(orgnameinp);
		Assert.assertEquals(status,true);//it is mandatory field thats why we are using hard assert
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(orgnameoup2,orgnameinp);// here we are soft assert bcs it is not a madatory field
		sa.assertAll();
		UtilityClassObject.getTest().log(Status.INFO,"successfully verified create orgization ");
		}
	@Test(groups = "regressiontest")
	public void createOrgnwithindustry() throws EncryptedDocumentException, IOException {
		//creating object for the utlity files
				//step 2:reading properties from excel file 
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel sheet");
				String value1 = eu.getDataFromExcel("orgnization", 4, 2);
				String industry = eu.getDataFromExcel("orgnization", 4, 3);
				String type = eu.getDataFromExcel("orgnization", 4, 4);
				//step 3: genrating a random number
				int rannumber = ju.getRandomNumber();
				//mergin of random with input 
				String orgnameinp = value1+rannumber;
				//step 4: login page
				wu.waitPageToLoad(driver);
				wu.maximizeBrowser(driver);
				HomePage hp=new HomePage(driver);
				OrgnizationPage op=new OrgnizationPage(driver);
				CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
				OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
				UtilityClassObject.getTest().log(Status.INFO,"clicking on create on new orginzation link");
				hp.getOrgnizationlink().click();
				//step 5: create new registration
				op.getCreateorgilink().click();
				cnp.getOrgnizationfield().sendKeys(orgnameinp);			 
				// for industry dropdown
				WebElement indu = cnp.getIndustrydrop();
				wu.selectbyValue(indu,industry);
				// for type dropdown
				WebElement typ = cnp.getTypedrop();
				wu.selectbyValue(typ,type);
				cnp.getSavebutton().click();
				UtilityClassObject.getTest().log(Status.INFO,"entered all deatils and selected industry and type and clicked on submit button");
				//step 6: validtion of data in output page
				String orgnameoup = oip.getOrgnameinheader().getText();		
				String orgnameoup2 = oip.getOrgname().getText();
				boolean status = orgnameoup.contains(orgnameinp);
				Assert.assertEquals(status,true);
				SoftAssert sa=new SoftAssert();
				sa.assertEquals(orgnameoup2, orgnameinp);
				//validation of dropdown industry and type 
				String indusvalidation = oip.getIndustry().getText();
				String typevalidation = oip.getType().getText();
				String result3 = ju.equalsChecks(industry,indusvalidation);
				System.out.println(industry+" is "+result3+" at the output page");	
				sa.assertEquals(type,typevalidation);
				UtilityClassObject.getTest().log(Status.INFO,"successfully created orgnization with industry type");
				//step 7: logout from the page
	}
	@Test(groups = "regressiontest")
	public void createorgwithphonenum() throws EncryptedDocumentException, IOException {
		// step 1:reading data from property file
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel sheet");
		String value1 = eu.getDataFromExcel("orgnization", 7, 2);
		String number = eu.getDataFromExcel("orgnization", 7, 3);
		//step 3: genrating a random number
		int rannumber = ju.getRandomNumber();
		//mergin of random with input 
		String orgnameinp = value1+rannumber;
		//step 4: login page
		wu.waitPageToLoad(driver);
		wu.maximizeBrowser(driver);
		HomePage hp=new HomePage(driver);
		OrgnizationPage op=new OrgnizationPage(driver);
		CreateNewOrgnizationPage cnp=new CreateNewOrgnizationPage(driver);
		OrgnizationInformationPage oip=new OrgnizationInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new orgnization link");
		hp.getOrgnizationlink().click();
		op.getCreateorgilink().click();
		cnp.getOrgnizationfield().sendKeys(orgnameinp);
		cnp.getPhonenumberfield().sendKeys(number);
		cnp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"entered orgnization name along with phone number and clicked on submit button");
		//step 6: validtion of data in output page
		String orgnameoup = oip.getOrgnameinheader().getText();
		String orgnameoup2 = oip.getOrgname().getText();
		boolean value = orgnameoup.contains(orgnameinp);
		Assert.assertEquals(value,true);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(orgnameoup2,orgnameinp);
		//validation for phone number
		String numberverif = oip.getPhonenumber().getText();
		String numberverify = numberverif.trim();
		sa.assertEquals(numberverify,number);
		UtilityClassObject.getTest().log(Status.INFO,"successfully created orgnization name with phone number");
	}
	}


