package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement CreateProductLookUpImg;
    
    public ProductPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getCreateProductLookUpImg() {
		return CreateProductLookUpImg;
	}
    
	/**
	 * This method will Click On Create Product LookUp Img
	 */
    public void ClickOnCreateProductLookUpImg()
    {
    	CreateProductLookUpImg.click();
    }

}
