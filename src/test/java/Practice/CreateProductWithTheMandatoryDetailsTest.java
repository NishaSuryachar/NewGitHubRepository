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
import ObjectRepository.CreateNewProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateProductWithTheMandatoryDetailsTest extends BaseClass {

	@Test
	public void CreateProductWithTheMandatoryDetails() throws IOException, InterruptedException
	{
        //READ DATA FROM EXCEL FILE
		String PRODUCT = eUtil.readDataFromExcel("Product", 1, 2);

		//step 4:Click On Product Link 
		HomePage hp=new HomePage(driver);
		hp.ClickOnProductLink();
		
		//step 5:Click On Create Product LookUp Img
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreateProductLookUpImg();

		//step 6: Create New Product With Mandatory Details
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.CreateNewProductWithMandatoryDetails(PRODUCT);

		//step 7: validate the product
		ProductInfoPage pip=new ProductInfoPage(driver);
		String product_id = pip.captureProductHeader();
		
		Assert.assertTrue(product_id.contains(product_id));
	}

}
