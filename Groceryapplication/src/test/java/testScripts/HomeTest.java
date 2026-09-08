package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainProjectSelenium.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends TestNGBase {
	HomePage obj1;
	@Test(description="Verify whether user is able to successfully logout")
	public void verifyWhetherUserAbleToSuccessfullyLogout() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		obj1=obj.LoginClick();
		
		
		obj1.clickAdmin();
		obj=obj1.clickLogOut();
		String actual=obj.verifyLogintextisDisplayed();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to logout ");
	}


}
