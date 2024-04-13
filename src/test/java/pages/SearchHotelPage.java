package pages;

import javax.swing.text.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class SearchHotelPage extends BasePage {

	
	  public SearchHotelPage() { 
		  PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(xpath = "//select[@name='location']") 
	  WebElement locationDropDown;
	  
	  @FindBy(xpath = "//select[@name='hotels']") 
	  WebElement hotelDropDown;
	  
	  @FindBy(xpath = "//select[@name='room_type']") 
	  WebElement roomTypeDropDown;
	  
	  @FindBy(xpath = "//select[@name='room_nos']")
	  WebElement
	  numberOfRoomsDropDown;
	  
	  @FindBy(xpath = "//input[@name='datepick_in']") 
	  WebElement checkInDate;
	  
	  @FindBy(xpath = "//input[@name='datepick_out']") 
	  WebElement checkOutDate;
	  
	  @FindBy(xpath = "//select[@name='adult_room']") 
	  WebElement
	  adutlsPerRoomDropDown;
	  
	  @FindBy(xpath = "//select[@name='child_room']")
	  WebElement
	  childrenPerRoomDropDown;
	  
	  @FindBy(xpath = "//input[@name='Submit']") 
	  WebElement searchButton;
	  
	  @FindBy(xpath = "//td[@class='welcome_menu']") 
	  WebElement verifyText;
	 
	
	  public void verifyText(String text) { 
		  verifyingSomeText(verifyText, text); 
	  }
	  
	  public void locationDropDown(String text) { 
		  selectDropDown(locationDropDown,text); 
		  }
	  
	  public void hotelDropDown(String text) { 
		  selectDropDown(hotelDropDown, text);
	  }
	  
	  public void roomTypeDropDown(String text){ 
		  selectDropDown(roomTypeDropDown, text);
	  }
	  
	  public void numberOfRoomsDropDown(String text) {
	  selectDropDown(numberOfRoomsDropDown, text);
	  }
	  
	  public void checkInDate(String date) { 
		  clear(checkInDate);
		  type(checkInDate,date);
		  }
	  
	  public void checkOutDate(String date) { 
		  clear(checkOutDate);
	  type(checkOutDate, date); 
	  }
	  
	  public void adutlsPerRoomDropDown(String text) {
	  selectDropDown(adutlsPerRoomDropDown, text);
	  }
	  
	  public void childrenPerRoomDropDown(String text) {
	  selectDropDown(childrenPerRoomDropDown, text); 
	  }
	  
	  public void searchButton() {
		  click(searchButton); 
	  }
	 
}