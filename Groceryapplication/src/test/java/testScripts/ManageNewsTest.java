package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProjectSelenium.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends TestNGBase {
	HomePage home;
	ManageNewsPage news;
	@Test(description="Verify whether user is able to add news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		news=home.clickManageNews();
		String addNews=ExcelUtilities.readStringData(0, 0, "AddNews");
		news.clickEdit().addNews(addNews).clickSave();
		boolean actual = news.verifyNewsWasCreatedSuccessfully();
	    Assert.assertTrue(actual,Constant.NEWSREPORTADDING);
	}
	@Test(description="Verify whether user is able to search news")
	public void verifyWhetherUserIsableToSearchNews() throws IOException {
		String username=ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password1);
		home=obj.LoginClick();
		news=home.clickManageNews();
		String newsTitleForSearch=ExcelUtilities.readStringData(0, 0, "AddNews");
		news.clickSearch().searchNews(newsTitleForSearch).clickSearchButton();
		String actual = news.verifySearchedNews();
		String expected = newsTitleForSearch;
		Assert.assertEquals(actual, expected,Constant.NEWSREPORTSEARCHINGERROR_STRING);
	}

}
