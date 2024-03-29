package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage
{
    @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement CreateVendorLookUpImg;
    
    public VendorsPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getCreateVendorLookUpImg() {
		return CreateVendorLookUpImg;
	}
    
	/**
	 * This method will click on Create Vendor LookUp Img
	 */
    public void ClickOnCreateVendorLookUpImg()
    {
    	CreateVendorLookUpImg.click();
    }
}
