package keywords;

import org.testng.Assert;

public class ValidateKeywords extends GenericKeywords{
  public void validateTitle(String expectedTitle) {
	  Assert.assertEquals(driver.getTitle(), expectedTitle);
  }
}
