package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice 
{
	@Test
	public void create()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = "create")
	public void Modify()
	{
		System.out.println("modify");
	}

	@Test
	public void delete()
	{
		System.out.println("delete");
	}
}
