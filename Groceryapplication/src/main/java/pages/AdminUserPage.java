package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	PageUtility pu=new PageUtility();
	public WebDriver driver;
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@onclick,'click_button(1)')]")WebElement newButton;
	@FindBy(xpath="//input[@id='username']")WebElement userName;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(id="user_type")WebElement userType;
	@FindBy(xpath="//button[@name='Create']")WebElement createButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement userCreatedSuccessfully;
	@FindBy(xpath="//a[normalize-space()='Search']")WebElement searchButton;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypeSearch;
	@FindBy(xpath="//input[@id='un']")WebElement searchingUsername;
	@FindBy(xpath="//button[@name='Search']")WebElement userNamesearchButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]")WebElement searchedUsername;
	public AdminUserPage clickUser() {
		newButton.click();
		return this;
	}
	
	public AdminUserPage enterUsername(String username) {
		userName.sendKeys(username);
		return this;
	}
	
	public AdminUserPage enterPassword(String password1) {
		password.sendKeys(password1);
		return this;
	}
	
	public AdminUserPage selectUserType() {
		pu.selectByVisbleText(userType, "Admin");
		return this;
		//Select obj = new Select(userType);
		//obj.selectByVisibleText("Admin");
		
	}
	public AdminUserPage save() {
		createButton.click();
		return this;
	}
	
	public boolean verifyUserCreatedSuccessfully() {
	    return userCreatedSuccessfully.isDisplayed();
	}
	public AdminUserPage clickSearch() {
		searchButton.click();
		return this;
	}
	public AdminUserPage enterUsernameSearch(String username) {
		searchingUsername.sendKeys(username);
		return this;
	}
	public AdminUserPage selectUserTypeSearch() {
		pu.selectByVisbleText(userTypeSearch, "Admin");
		return this;
			//Select obj = new Select(userTypeSearch);
			//obj.selectByVisibleText("Admin");
	}
	public AdminUserPage userNameSearch() {
		userNamesearchButton.click();
		return this;
		
	}
	public String verifySearchedUsername() {
	    return searchedUsername.getText();
	}
	
	
	

}
