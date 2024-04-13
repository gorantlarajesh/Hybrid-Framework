package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
     
	public void openBrowser() {
     String	browserName = configProp.getProperty("browser");
     if(browserName.equalsIgnoreCase("chrome")) {
    	 driver = new ChromeDriver();
     }
     else if(browserName.equalsIgnoreCase("edge")) {
    	 driver = new EdgeDriver();
     }
     else if(browserName.equalsIgnoreCase("firefox")) {
    	 driver = new FirefoxDriver();
     }
	}
	public void launchApp() {
	    driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
}
	public void type(String locatorkey ,String text) {
		getElement(locatorkey).sendKeys(text);
	}
	public void clickElement(String locatorkey) {
		getElement(locatorkey).click();
	}
	WebElement element;
	public WebElement getElement(String locatorkey) {
		element=driver.findElement( getByclass( locatorkey));
		return element;
	}
	By by;
	public By getByclass(String locatorkey) {
		if(locatorkey.endsWith("_id")) {
			by= By.id(locatorsProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name")) {
			by = By.name(locatorsProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_linkText")) {
			by = By.linkText(locatorsProp.getProperty(locatorkey));
		}
		else {
			by = By.xpath(locatorsProp.getProperty(locatorkey));
		}
		return by;
	}
	public void closeWindow() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}