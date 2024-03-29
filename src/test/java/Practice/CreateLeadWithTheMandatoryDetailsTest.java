package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewLeadPage;
import ObjectRepository.HomePage;
import ObjectRepository.LeadInfoPage;
import ObjectRepository.LeadPage;
import ObjectRepository.LoginPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateLeadWithTheMandatoryDetailsTest extends BaseClass
{

	@Test(groups = "RegressionSuite")
	public void CreateLeadWithTheMandatoryDetails() throws IOException, InterruptedException
	{
		
		//READ DATA FROM EXCEL FILE
		String LASTNAME =eUtil.readDataFromExcel("Lead", 1, 2);
		String COMPANY = eUtil.readDataFromExcel("Lead", 1, 3);

		
		//step 4: click on LeadLink
		HomePage hp=new HomePage(driver);
		hp.ClickOnLeadLink();

		//Step 5: click on Click On Create Lead LookUp Img
		LeadPage leadp=new LeadPage(driver);
		leadp.ClickOnCreateLeadLookUpImg();

		//step 6:Create New Lead With Mandatory Details
		CreateNewLeadPage cnlp=new CreateNewLeadPage(driver);
		cnlp.CreateLeadWithMandatoryDetails(LASTNAME, COMPANY);
		
		LeadInfoPage lip=new LeadInfoPage(driver);
		String lead_id = lip.captureLeadHeader();
		
		Assert.assertTrue(lead_id.contains(LASTNAME));
	}
}
