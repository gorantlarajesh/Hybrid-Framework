package testscripts.regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class toValidateLoginDetailsUsingDataDriven extends BaseTest {

	@Test(dataProvider="getData")
	public void toValidateLoginUsingDataDrivenTest (String us, String ps, String tl) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(us);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Assert.assertEquals(driver.getTitle(), tl);
	}
	
	@DataProvider
	public  Object[][] getData() {
		Object[][]	a = new Object[4][3];
		a[0][0]="Rajesh00";
        a[0][1]="Rajesh@99";
        a[0][2]="Adactin.com - Search Hotel";	
         
        a[1][0]="Rajesh00";
        a[1][1]="Rajesh@98";
        a[1][2]="Adactin.com - Hotel Reservation System";	
        
        a[2][0]="Rajesh03";
        a[2][1]="Rajesh@99";
        a[2][2]="Adactin.com - Hotel Reservation System";	
        
        a[3][0]="Rajesh03";
        a[3][1]="Rajesh@98";
        a[3][2]="Adactin.com - Hotel Reservation System";	
		return a;
		
	}
}

