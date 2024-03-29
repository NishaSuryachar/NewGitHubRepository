package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage             //RULE 1: create a seperate pom class for every webpage
{
	//RULE 2: Identify the web elements using findby and make them as private
  @FindBy(name="user_name") 
  private WebElement usernameEdt;
	
  @FindBy(name="user_password")
  private WebElement passwordEdt;
  
  @FindBy(id="submitButton")
  private WebElement LoginBtn;
  
  
  //RULE 3: Create a constructor for initialization
  public LoginPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

  
  //RULE 4: provide Getters
public WebElement getUsernameEdt() 
{
	return usernameEdt;
}

public WebElement getPasswordEdt()
{
	return passwordEdt;
}

public WebElement getLoginBtn()
{
	return LoginBtn;
}
 

//Bussiness Library
/**
 * This method will perform login operation
 * @param username
 * @param password
 */
public void loginToApp(String username,String password)
{
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	LoginBtn.click();
}
  
	
}
