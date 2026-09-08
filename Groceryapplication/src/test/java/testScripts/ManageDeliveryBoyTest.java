package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProjectSelenium.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends TestNGBase {
	HomePage home;
	ManageDeliveryBoyPage obj1;
	@Test(description="Verify whether user enable to add delivery boy")
	public void verifyWhetherUSerIsEnableToAddDeliveryBoy() throws IOException{
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		obj1=home.clickDeliveryBoy();
		String DeliveryBoyName=ExcelUtilities.readStringData(0, 0, "DeliveryBoyDetails");
		String DeliveryBoyAddress=ExcelUtilities.readStringData(0, 1, "DeliveryBoyDetails");
		RandomDataUtility ru=new RandomDataUtility();
		String DeliveryBoyEmail=ru.genarateRandomEmailID();
		String DeliveryBoyPhNo=ru.genarateRandomPhoneNumber();
		String DeliveryBoyUserName=ru.genarateRandomUserName();
		String DeliveryBoyPassword=ExcelUtilities.readStringData(0, 2, "DeliveryBoyDetails");
		obj1.clickNew().addName(DeliveryBoyName).newEmail(DeliveryBoyEmail).phoneNo(DeliveryBoyPhNo).newAddress(DeliveryBoyAddress).enterUsername(DeliveryBoyUserName).enterPassword(DeliveryBoyPassword).saveButton();
		boolean actual = obj1.verifyDeliveryBoyCreatedSuccessfully();
	    Assert.assertTrue(actual,Constant.NEWDELIVERYBOYADDING);
			
	}
	@Test(description="verify whether delivery boy is enable to search")
	public void verifyWhetherDeliveryBoyIsEnableToSearch() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		obj1=home.clickDeliveryBoy();
		String searchName=ExcelUtilities.readStringData(0, 0, "DeliveryBoySearchDetails");
		String searchEmail=ExcelUtilities.readStringData(0, 1, "DeliveryBoySearchDetails");
		String searchPhone=ExcelUtilities.readStringData(0, 2, "DeliveryBoySearchDetails");
		obj1.searchButton().nameForSearching(searchName).emailForSearching(searchEmail).phNoForSearching(searchPhone).clickSearch();	
		String actual = obj1.verifySearchedUsername();
		String expected = searchName;
		Assert.assertEquals(actual, expected,Constant.DELIVERYBOYSEARCHINGERROR);
		
	}

}
