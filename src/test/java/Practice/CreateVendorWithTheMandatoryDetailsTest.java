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
import ObjectRepository.CreateNewVendorPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.VendorInfoPage;
import ObjectRepository.VendorsPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateVendorWithTheMandatoryDetailsTest extends BaseClass{

	@Test
	public void CreateVendorWithTheMandatoryDetails() throws IOException, InterruptedException
	{
		//READ DATA FROM EXCEL FILE
		String VENDOR_NAME = eUtil.readDataFromExcel("Vendor", 1, 2);

		//step 4:Click On vendor Link 
		HomePage hp=new HomePage(driver);
		hp.MouseHoverOnMore(driver);

		//step 5:Click On Create vendor LookUp Img
		VendorsPage vp=new VendorsPage(driver);
		vp.ClickOnCreateVendorLookUpImg();

		//step 6: Create New vendor With Mandatory Details
		CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
		cnvp.CreateNewVendorPageWithMandatoryDetails(VENDOR_NAME);

		//step 7: validate the vendor
		VendorInfoPage vip=new VendorInfoPage(driver);
		String Vendor_name = vip.captureProduct();
		
		Assert.assertTrue(Vendor_name.contains(VENDOR_NAME));
     }
}
