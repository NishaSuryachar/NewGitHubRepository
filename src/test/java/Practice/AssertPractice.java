package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice 
{
	@Test
     public void HardAssertEx()
     {
    	 String a="i";
    	 System.out.println("====Step 1=====");
    	 System.out.println("====Step 2=====");
    	 Assert.assertEquals(1, 1);
    	 Assert.assertTrue(a.contains("i"));
    	 System.out.println("====Step 3=====");
    	 System.out.println("====Step 4=====");
    	 System.out.println("====Step 5=====");
     }
	
	@Test
	 public void SoftAssertEx()
     {
		SoftAssert sa=new  SoftAssert();
		System.out.println("***********Soft Assert**********");
    	 String a="i";
    	 System.out.println("====Step 1=====");
    	 System.out.println("====Step 2=====");
    	 sa.assertEquals(1, 1);
    	 sa.assertTrue(a.contains("i"));
    	 System.out.println("====Step 3=====");
    	 System.out.println("====Step 4=====");
    	 System.out.println("====Step 5=====");
    	 sa.assertAll();
     }
}
