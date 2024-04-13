package pages;

import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class verifyLoginDetailsUsingPomHybrid extends BaseTest {

	@Test(dataProvider = "getData")
	
	  public void verifyLoginDetailsTest(HashMap<String, String> datamap) {
	  LoginPage lp = new LoginPage(); 
	  lp.Username_Login(datamap.get("username"));
	  lp.Password_Login(datamap.get("password"));
	  lp.Login_Button();
	  SearchHotelPage sh = new SearchHotelPage();
	  sh.validateTitle(datamap.get("Expected Title"));
	  sh.verifyText(datamap.get("ActualText"));
	  sh.locationDropDown(datamap.get("Location"));
	  sh.hotelDropDown(datamap.get("Hotels"));
	  sh.roomTypeDropDown(datamap.get("Roomtype"));
	  sh.numberOfRoomsDropDown(datamap.get("Number of Room"));
	  sh.checkInDate(datamap.get("Check In Date"));
	  sh.checkOutDate(datamap.get("Check Out Date"));
	  sh.adutlsPerRoomDropDown(datamap.get("Adults Per Room"));
	  sh.childrenPerRoomDropDown(datamap.get("Children Per Room"));
	  sh.searchButton(); }
	 
	
	@DataProvider
	public Object[][] getData() {
		Object[][] a = new Object[1][1];
		a[0][0] = UtilKit.getDataFromExcel("TC-102");
		return a;

	}

}
