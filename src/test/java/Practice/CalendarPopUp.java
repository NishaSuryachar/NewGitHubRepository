package Practice;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPopUp {

	public static void main(String[] args) 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='Mon Mar 04 2024']")).click();
		for(int i=0;i<=4;i++)
		{
		try
		   {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			
			driver.findElement(By.xpath("//div[@aria-label='Fri Aug 09 2024']")).click();
		   }
		catch(Exception e)
		{
			driver.findElement(By.xpath("//div[@aria-label='Fri Aug 09 2024']")).click();
		}
		}

		//	LocalDateTime date = LocalDateTime.now();
        //  System.out.println(date);
//         String target = driver.findElement(By.xpath("//div[@aria-label='Fri Aug 09 2024']")).getText();
//		for(int i=0;i<=4;i++)
//		{
//			if()
//			{
//				
//			}
//		}
	}

}
