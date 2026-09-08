package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility obj=new WaitUtility();
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
		
	}
	//(locator=attributeValue)
	@FindBy(name="username")WebElement userName;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement clickLogin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement sevenmart;
	
	
	
	public LoginPage enterUsername(String username) {
		userName.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password1) {
		password.sendKeys(password1);
		return this;
	}
	
	public HomePage LoginClick() {
		obj.waitUntilElementToBeClickable(driver, clickLogin);
		clickLogin.click();
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardDisplayed() {
		return dashBoard.isDisplayed();
			
	}
	public String verifyLogintextisDisplayed() {
		return sevenmart.getText();
	}

}
