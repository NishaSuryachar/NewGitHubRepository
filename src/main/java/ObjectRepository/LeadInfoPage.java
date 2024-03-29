package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage
{
	@FindBy(className = "dvHeaderText")
	private WebElement LeadHeader;

	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadHeader()
	{
		return LeadHeader;
	}
    /**
     * This method will captureLeadHeader and return to caller
     * @return
     */
	public String captureLeadHeader()
	{
		return LeadHeader.getText();
	}
}
