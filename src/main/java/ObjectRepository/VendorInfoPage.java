package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage 
{
    @FindBy(className = "lvtHeaderText")
    private WebElement VendorHeader;
    
    public VendorInfoPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getVendorHeader() {
		return VendorHeader;
	}
    
	/**
	 * This method will capture Product Id and return to caller
	 * @return
	 */
	public String captureProduct()
	{
		return VendorHeader.getText();
	}
}
