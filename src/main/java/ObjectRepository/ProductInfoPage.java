package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
    @FindBy(className = "lvtHeaderText")
    private WebElement ProductHeader;
    
    public ProductInfoPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

	public WebElement getProductHeader() {
		return ProductHeader;
	}
    
	/**
	 * This Method will capture productheader and return to caller
	 * @return
	 */
    public String captureProductHeader()
    {
    	return ProductHeader.getText();
    }
}
