package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage 
{
    @FindBy(name = "vendorname")
    private WebElement vendorname;
    
    @FindBy(xpath  = "//input[@type='submit']")
    private WebElement saveBtn;
    
    public CreateNewVendorPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getVendorname() {
		return vendorname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
	public void CreateNewVendorPageWithMandatoryDetails(String VendorNameValue)
	{
		vendorname.sendKeys(VendorNameValue);
		saveBtn.click();
	}
    
}
