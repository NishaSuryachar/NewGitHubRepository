package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

/**
 * This class Consists of basic configuartion annotation of TestNG
 * @author hp
 *
 */
public class BaseClass 
{
    public PropertyFileUtility pUtil=new PropertyFileUtility();
    public ReadDataFromExcelUtility eUtil=new ReadDataFromExcelUtility();
    public SeleniumUtility sUtil=new SeleniumUtility();
    public WebDriver driver;
    
    //For listeners
    public static WebDriver sDriver;
    
    @BeforeSuite(groups = {"RegressionSuite","SmokeSuite"})
    public void bsConfig()
    {
    	System.out.println("=======DB Connection successfull========");
    }
    
    //@Parameters("browser")
    //@BeforeTest
    @BeforeClass(alwaysRun = true)
    public void bcConfig(/*String BROWSER*/) throws IOException
    {
    	String URL = pUtil.readDataFromPropertyFile("url");
    	 driver=new ChromeDriver();
//         if(BROWSER.contains("chrome"))
//         {
//    	     driver=new ChromeDriver();
//         }
//         else if(BROWSER.contains("edge"))
//         {
//    	     driver=new EdgeDriver();
//         }
//         if(BROWSER.contains("firefox"))
//         {
//    	     driver=new FirefoxDriver();
//         }
        sUtil.maximizewindow(driver);
    	sUtil.implicitWait(driver);
    	driver.get(URL);
    	
    	//For Listerners
    	sDriver=driver;
    	
    	System.out.println("=======browser launch succesfull========");
    }
    
    @BeforeMethod(alwaysRun = true)
    public void bmConfig() throws IOException
    {
    	String USERNAME = pUtil.readDataFromPropertyFile("username");
    	String PASSWORD = pUtil.readDataFromPropertyFile("password");
    	LoginPage lp=new LoginPage(driver);
    	lp.loginToApp(USERNAME, PASSWORD);
    	System.out.println("=======Login of App succesfull========");
    }
    
    @AfterMethod(alwaysRun = true)
    public void amConfig() throws InterruptedException
    {
    	HomePage hp=new HomePage(driver);
    	hp.LogOutApp(driver);
    	System.out.println("=======LogOut of App succesfull========");
    }
    
    
    //@AfterTest
    @AfterClass(alwaysRun = true)
    public void acConfig()
    {
    	driver.close();
    	System.out.println("=======browser closure succesfull========");
    }
    
    @AfterSuite(alwaysRun = true)
    public void asConfig()
    {
    	System.out.println("=======DB Closure succesfull========");
    }
}
