package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class BasePage extends BaseTest{

public void validateTitle(String expectedTitle) {	
	Assert.assertEquals(driver.getTitle(),  expectedTitle);
}
 public void  verifyingSomeText(WebElement element, String expectedText) {
	 Assert.assertEquals(element.getText(), expectedText);
 }
 public void selectDropDown( WebElement element,String text) {
	 new Select(element).selectByVisibleText(text);
 }
 public void clear(WebElement element) {
	 element.clear();
 }
 public void type(WebElement element, String text) {
	 element.sendKeys(text);
 }
 
 public void click(WebElement element) {
	 element.click();
 }
}
