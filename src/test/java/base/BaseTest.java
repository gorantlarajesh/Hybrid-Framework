package base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;



import org.openqa.selenium.WebDriver;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties configProp;
	public static FileInputStream fis2;
	public static Properties locatorsProp;
 
    
	@BeforeTest
	public void bothFile() throws IOException {
		fis = new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		configProp = new Properties();
		configProp.load(fis);
		fis2 = new FileInputStream("src\\test\\resources\\Properties\\locators.properties");
		locatorsProp = new Properties();
		locatorsProp.load(fis2);
		
		
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		String browserName = configProp.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
