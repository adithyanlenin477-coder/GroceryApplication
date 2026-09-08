package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainProjectSelenium.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends TestNGBase {
	HomePage hp;
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		hp=obj.LoginClick();
		boolean dashboardValue = obj.verifyWhetherDashboardDisplayed();
		Assert.assertTrue(dashboardValue,Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login with invalid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1).LoginClick();
		String actual = obj.verifyLogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to login with invalid username")
	public void verifyUserLoginWithInvalidUsername() throws IOException {
		String username = ExcelUtilities.readStringData(2, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1).LoginClick();
		String actual = obj.verifyLogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid password", groups = { "smoke" },dataProvider="LoginData")
	public void verifyUserLoginWithInvalidPassword(String username,String password1 ) throws IOException {
		/*String username = ExcelUtilities.readStringData(3, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(3, 1, "LoginPage");*/
		LoginPage obj = new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1).LoginClick();
		String actual = obj.verifyLogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDPASSWORDERROR);
	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "adhi123" }, new Object[] { "admin", "ammu123" } };

	}
}
