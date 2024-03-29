package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventWithTheMandatoryDetails {

	public static void main(String[] args) 
	{
		  //launch browser
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  //Login into Application
		  driver.get("http://localhost:8888/");
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  //navigate to calendar Link
		  Actions a=new Actions(driver);
		  a.moveToElement(driver.findElement(By.xpath("//a[text()='Calendar']"))).click().build().perform();
		  //click on AllEvent  and todos link
		  driver.findElement(By.xpath("//a[text()='All Events & Todos']")).click();
		  //click on create an event link
		  driver.findElement(By.xpath("//a[text()='Create an Event']")).click();
		  //create calendar event with mandatory details
		  driver.findElement(By.name("subject")).sendKeys("Redmi Sales Event");
		  WebElement planned = driver.findElement(By.xpath("(//select[@class='small'])[3]"));
		  Select s1=new Select(planned);
		  s1.selectByValue("Held");
		  WebElement start_hr = driver.findElement(By.id("starthr"));
		  Select s2=new Select(start_hr);
		  s2.selectByVisibleText("10");
		  WebElement start_min = driver.findElement(By.name("startmin"));
		  Select s3=new Select(start_min);
		  s3.selectByVisibleText("30");
		  WebElement end_hr = driver.findElement(By.id("endhr"));
		  Select s4=new Select(end_hr);
		  s4.selectByVisibleText("06");
		  WebElement end_min = driver.findElement(By.name("endmin"));
		  Select s5=new Select(end_min);
		  s5.selectByVisibleText("00");
		  WebElement end_fmt = driver.findElement(By.name("endfmt"));
		  Select s6=new Select(end_fmt);
		  s6.selectByVisibleText("PM");
		  driver.findElement(By.xpath("(//img[@alt='Set Date'])[1]")).click();
		  driver.findElement(By.xpath("//td[text()='19']")).click();
		  driver.findElement(By.id("jscal_trigger_due_date")).click();
		  driver.findElement(By.xpath("(//td[@class='day'])[33]")).click();
		    driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		    //validate for calendar event
		    String element = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		    if(element.contains("Redmi Sales Event"))
		    {
		    	System.out.println("PASS");
		    }
		    else
		    {
		    	System.out.println("FAIL");
		    }
		    //Logout from App
		  driver.findElement(By.xpath("(//td[@class='small'])[2]")).click();
		  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		  //close browser
		  driver.quit();
	}

}
