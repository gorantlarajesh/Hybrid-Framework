package keywords;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginDetailsUsingKeyword extends BaseTest{
	@Test(dataProvider="getData")
	public void ValidateLoginDetailsTest(HashMap<String, String> someData) {
		 ApplicationKeywords app = new ApplicationKeywords();
		 app.openBrowser();
		 app.launchApp();
		 app.type("Username_textbox", someData.get("username"));
		 app.type("Password_textbox", someData.get("password"));
		 app.clickElement("Login_click");
		 app.validateTitle(someData.get("Expected Title"));
		 app.closeWindow();
	}
	@DataProvider
	public Object[][] getData() {
    Object[][] a =  new Object[1][1];
    a[0][0] =UtilKit.getDataFromExcel("TC-100");
		return a;
		
	}
}
