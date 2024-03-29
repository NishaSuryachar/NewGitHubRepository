package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage
{
	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(name = "company")
	private WebElement company;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement SaveBtn;

	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
    
	/**
	 * This method Will create new Lead
	 * @param Lastname
	 * @param Company
	 */
	public void CreateLeadWithMandatoryDetails(String Lastname,String Company)
	{
		lastname.sendKeys(Lastname);
		company.sendKeys(Company);
		SaveBtn.click();
	}

}
