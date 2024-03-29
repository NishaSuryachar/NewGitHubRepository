package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
   @FindBy(linkText = "Contacts")
   private WebElement ContactsLink;
   
   @FindBy(linkText = "Leads")
   private WebElement LeadsLink;
   
   @FindBy(linkText = "Products")
   private WebElement ProductsLink;
   
   @FindBy(linkText = "Vendors")
   private WebElement VendorsLink;
   
   @FindBy(linkText = "Calendar")
   private WebElement CalendarLink;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
   private WebElement MoreLink;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement AdministationLookUp;
   
   @FindBy(linkText = "Sign Out")
   private WebElement Signout;
   
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }

public WebElement getContactsLink() {
	return ContactsLink;
}

public WebElement getLeadsLink() {
	return LeadsLink;
}

public WebElement getProductsLink() {
	return ProductsLink;
}

public WebElement getVendorsLink() {
	return VendorsLink;
}

public WebElement getCalendarLink() {
	return CalendarLink;
}

public WebElement getMoreLink() {
	return MoreLink;
}

public WebElement getAdministationLookUpLink() {
	return AdministationLookUp;
}

public WebElement getSignoutLink() {
	return Signout;
}
   public void ClickOnContactLink()
   {
	   ContactsLink.click();
   }
   public void ClickOnLeadLink()
   {
	   LeadsLink.click();
   }
   public void ClickOnProductLink()
   {
	   ProductsLink.click();
   }
//   public void ClickOnVendorsLink()
//   {
//	   VendorsLink.click();
//   }
   public void ClickOnCalendarLink()
   {
	   CalendarLink.click();
   }
   public void MouseHoverOnMore(WebDriver driver) throws InterruptedException
   {
	   MouseHoverAction(driver,MoreLink);
	   Thread.sleep(1000);
	   VendorsLink.click();
   }
   /**
    * This method will logout from Application
    * @param driver
    * @throws InterruptedException
    */
   public void LogOutApp(WebDriver driver) throws InterruptedException
   {
	   MouseHoverAction(driver, AdministationLookUp);
	   Thread.sleep(2000);
	   Signout.click();
   }
 }







