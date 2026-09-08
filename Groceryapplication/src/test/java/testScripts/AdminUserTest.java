package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mainProjectSelenium.TestNGBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class AdminUserTest extends TestNGBase {
	HomePage home;
	AdminUserPage obj1;
	@Test(description="Verify whether user is able to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		
		obj1=home.clickAdminUsers();

		
		RandomDataUtility ru=new RandomDataUtility();
		String usernameAdmin=ru.genarateRandomUserName();
		String passwordAdmin=ru.generateRandomPassword();
		obj1.clickUser().enterUsername(usernameAdmin).enterPassword(passwordAdmin).selectUserType().save();
		boolean actual = obj1.verifyUserCreatedSuccessfully();
	    Assert.assertTrue(actual,"User is not created successfully");
	}
	@Test(description="Verify whether user is able to search newly added admin user")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		obj1=home.clickAdminUsers();
		String searchingUsername=ExcelUtilities.readStringData(0, 0, "SearchPage");
		obj1.clickSearch().enterUsernameSearch(searchingUsername).selectUserTypeSearch().userNameSearch();
		String actual = obj1.verifySearchedUsername();
		String expected = searchingUsername;
		Assert.assertEquals(actual, expected, "Searched username is not displayed");
		
	}

}
