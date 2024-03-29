package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage
{
    @FindBy(name = "productname")
    private WebElement productname;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveBtn;
    
    public CreateNewProductPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
	/**
	 * This method Will Create New Product With Mandatory Details
	 * @param Productname
	 */
    public void CreateNewProductWithMandatoryDetails(String Productname)
    {
    	productname.sendKeys(Productname);
    	saveBtn.click();
    }
}
