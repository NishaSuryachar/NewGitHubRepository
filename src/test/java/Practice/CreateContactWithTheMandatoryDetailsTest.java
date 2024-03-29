package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.ReadDataFromExcelUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateContactWithTheMandatoryDetailsTest extends BaseClass
{
	@Test(groups = "SmokeSuite")
	public void CreateContactWithTheMandatoryDetails() throws IOException, InterruptedException
	{
		
		//READ DATA FROM EXTERNAL FILE
		String LASTNAME =eUtil.readDataFromExcel("Contacts", 1, 2);
		String LeadSource = eUtil.readDataFromExcel("Contacts", 1, 3);

		
		//step 3: click on contact Link
		HomePage hp=new HomePage(driver);
		hp.ClickOnContactLink();

		//step 4:Click on Click On Create Contacts LookUp Img
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickOnCreateContactsLookUpImg();

		
		
		//step 5: create Create New Contact With mandatoru Fields
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.ClickOnCreateNewContactPage(LASTNAME,LeadSource);
        
		
		
		 //step 7: capture contactHeader
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contact_id =cip.CaptureContactHeader();
		
		 //step 7: validate for contact
		Assert.assertTrue(contact_id.contains(LASTNAME));
	    
		
	}
	@Test
	public void sample()
	{
		System.out.println("Hello");
	}
}
