package pages;

import java.util.HashMap;

import org.apache.logging.log4j.util.PropertySource.Util;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class toValidateLoginUsingPageFactory extends BaseTest {
      @Test(dataProvider="getData")     
	public void ValidateLoginTest(HashMap<String, String> somedata) {
		LoginPage  lp = PageFactory.initElements(driver, LoginPage.class);
		lp.Username_Login(somedata.get("username"));
		lp.Password_Login(somedata.get("password"));
		lp.Login_Button();
		lp.validateTitle("Adactin.com - Search Hotel");
	}
       @DataProvider
       public Object[][] getData() {
      Object[][] a = new Object[1][1];
      a[0][0] = UtilKit.getDataFromExcel("TC-100");
		return a;
    	   
       }
}
