package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage 
{
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateLeadLookUp;

	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeadLookUp()
	{
		return CreateLeadLookUp;
	}

	/**
	 * This method will Click On Create Lead LookUp Img
	 */
	public void ClickOnCreateLeadLookUpImg()
	{
		CreateLeadLookUp.click();
	}
}
