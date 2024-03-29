package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains the generic methods related to selenium web Driver
 * @author hp
 *
 */
public class SeleniumUtility
{
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
   public void maximizewindow(WebDriver driver)
   {
	   driver.manage().window().maximize();
   }
   
   /**
    * This method will minimize the window
    * @param driver
    */
   public void minimizewindow(WebDriver driver)
   {
	   driver.manage().window().minimize();
   }
   
   /**
    * This method will add 10 seconds of implicitly wait
    * @param driver
    */
   public void implicitWait(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   
   /**
    * This method will wait for 10 sec fo webelement to be visible
    * @param driver
    */
   public void waitforElementToBeVisible(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   /**
    * This method will wait for 30 sec for webelement to be clickable
    * @param driver
    * @param element
    */
   public void waitforclickable(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   
   /**
    * This method will wait for 30 sec for webelement to be selected
    * @param driver
    * @param element
    */
   public void waitforSelectedElement(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.elementToBeSelected(element));
   }
 
/**
 * This method will handle drop down menu by index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}

/**
 * this method will handle drop down menu by text
 * @param element
 * @param text
 */
public void handleDropDown(WebElement element,String text)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}


/**
 * This method will handle drop down menu by value
 * @param value
 * @param element
 */
public void handleDropDown(String value,WebElement element)
{
	Select s=new Select(element);
	s.selectByValue(value);
}

/**
 * This method will perform hover action on the element
 * @param driver
 * @param move
 */
public void MouseHoverAction(WebDriver driver,WebElement move)
{
	Actions a=new Actions(driver);
	a.moveToElement(move).build().perform();
}


/**
 * This method will perform right click action on WebPage
 * @param context
 * @param driver
 */
public void rightClickAction(WebElement context,WebDriver driver)
{
	Actions a=new Actions(driver);
	a.contextClick(context).build().perform();;
}


/**
 * This method will perform double click on element
 */
public void doubleClick(WebElement double_click,WebDriver driver)
{
	Actions a=new Actions(driver);
	a.doubleClick(double_click).build().perform();;
}


/**
 * This method will perform drag and drop actions on webPage
 * @param driver
 * @param source
 * @param dst
 */
public void DragAndDropAction(WebDriver driver,WebElement source,WebElement dst)
{
	Actions a=new Actions(driver);
	a.dragAndDrop(source, dst).build().perform();;
}

/**
 * This method will perform scroll down the webpage
 * @param driver
 * @param element
 */
public void ScrollDownAction(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.keyDown(Keys.PAGE_DOWN).build().perform();
}

/**
 * This method will scroll Up the webpage
 * @param driver
 * @param element
 */
public void ScrollUpAction(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.keyDown(Keys.PAGE_UP).build().perform();
}

/**
 * This method will scroll the webpage upto particular webelement
 * @param driver
 * @param element
 */
public void scrollIntoView(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
}

/**
 * This method will Scroll down the webpage
 * @param driver
 */
public void scrollToDown(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,1000);");
}

/**
 * This method will scroll up the webpage
 * @param driver
 */
public void scrollToUp(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,-1000);");
}

/**
 * This method will value the data to hidden Webelement
 * @param driver
 * @param element
 */
public void hiddenElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='value';", element);
}

/**
 * This method will click the disable Webelement
 * @param driver
 * @param element
 */
public void disbleElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}


/**
 * This method will handles frames by index
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,int frameindex)
{
	driver.switchTo().frame(frameindex);
}


/**
 * This method will handle frames by Name or Id
 * @param driver
 * @param framenameOrId
 */
public void handleFrame(WebDriver driver,String framenameOrId)
{
	driver.switchTo().frame(framenameOrId);
}


/**
 * This method will handle frame by element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}


/**
 * This method will switch back to parent window
 * @param driver
 */
public void switchToparent(WebDriver driver)
{
	driver.switchTo().parentFrame();
}


/**
 * This method will accept the alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	 driver.switchTo().alert().accept();
	
}


/**
 * This method will cancel the alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
	
}

/**
 * This method Enter the text into alert popup
 * @param driver
 * @param text
 */
public void enterTextAlert(WebDriver driver,String text)
{
	driver.switchTo().alert().sendKeys(text);
}

/**
 * This method will capture the alert text and return it to caller 
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
	 
}

/**
 * This method will capture the screenshot and return the path to the caller
 * @param driver
 * @param ScreenShotName
 * @return
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,String ScreenShotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\ScreenShots\\"+ScreenShotName+".png");
	Files.copy(src, dst);
	return dst.getAbsolutePath();//used for extent reports
}
}
