package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class IRetryAnalyserPractice 
{
	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
     public void sample()
     {
		Assert.fail();
    	System.out.println("Hi");
     }
}
