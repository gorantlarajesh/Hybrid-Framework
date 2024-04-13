package testscripts.regression;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.util.PropertySource.Util;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import dev.failsafe.internal.util.Assert;
import utils.UtilKit;

public class toValidateLoginUsingExcelDataDriven extends BaseTest  {
    @Test(dataProvider="getData")
    public void toValidateLoginDetailsTest(HashMap<String, String> someData) {
    	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(someData.get("username"));
    	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(someData.get("password"));
    	 driver.findElement(By.xpath("//input[@id='login']")).click();
       assertEquals(driver.getTitle(), someData.get("Expected Title"));
    }
   @DataProvider
   public Object[][] getData() {
	  Object[][]  a =  new Object[1][1];
	  a[0][0] =UtilKit.getDataFromExcel("TC-100");
	return a;
	   
   }
}
