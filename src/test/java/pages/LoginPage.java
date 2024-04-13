package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
   
	
	  public LoginPage() {
	  
	  PageFactory.initElements(driver, this);
	  
	  }
	  
	  @FindBy(xpath ="//input[@id='username']" ) 
	  WebElement username_login;
	  
	  @FindBy(xpath="//input[@id='password']")
	  WebElement Password_Login;
	  
	  @FindBy(xpath ="//input[@id='login']") 
	  WebElement Login_Button;
	  
	  
	  public void Username_Login(String text) { 
		 type(username_login, text);
 }
	  
	  public void Password_Login(String text){ 
		  type(Password_Login, text);
	  }
	  
	  public void Login_Button() { 
		  click(Login_Button);
	  }
	  
	 
}

