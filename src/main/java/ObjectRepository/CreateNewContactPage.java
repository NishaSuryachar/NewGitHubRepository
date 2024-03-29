package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility
{
   @FindBy(name="lastname")
   private WebElement lastname;
   
   @FindBy(name="leadsource")
  private WebElement leadsourceDropDown; 
   
   @FindBy(xpath ="//input[@type='submit']")
   private WebElement SaveBtn; 
    
   public CreateNewContactPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

public WebElement getLastname() {
	return lastname;
}

public WebElement getLeadsourceDropDown() {
	return leadsourceDropDown;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

/**
 * This method will create new Contact
 * @param Lastname
 */
public void ClickOnCreateNewContactPage(String Lastname)
{
	lastname.sendKeys(Lastname);
	SaveBtn.click();
}


/**
 * This method will create new Contact
 * @param Lastname
 * @param LeadSource
 */
 public void ClickOnCreateNewContactPage(String Lastname,String LeadSourceValue)
 {
	lastname.sendKeys(Lastname);
    handleDropDown(leadsourceDropDown, LeadSourceValue);
	SaveBtn.click();
}
 
  
}
