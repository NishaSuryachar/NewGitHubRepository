package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	@FindBy(className = "dvHeaderText")
	private WebElement ContactHeader;

	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeader()
	{
		return ContactHeader;
	}

	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String CaptureContactHeader()
	{
		return ContactHeader.getText();
	}

}
