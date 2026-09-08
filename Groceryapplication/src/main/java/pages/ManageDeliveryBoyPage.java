package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space()='New']")WebElement newButton;
	@FindBy(xpath="//input[@id='name']")WebElement name;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//textarea[@id='address']")WebElement address;
	@FindBy(xpath="//input[@id='username']")WebElement userName;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//button[normalize-space()='Save']")WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]//h5")WebElement alertMessege;
	@FindBy(xpath="//a[contains(@class,'btn-primary') and normalize-space()='Search']")WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")WebElement searchingName;
	@FindBy(xpath="//input[@id='ut']")WebElement searchingEmail;
	@FindBy(xpath="//input[@id='ph']")WebElement searchingPhNo;
	@FindBy(xpath="//button[@type='submit' and @name='Search']")WebElement clickSearchButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]")WebElement searchedName;
	
	
	public ManageDeliveryBoyPage clickNew() {
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage addName(String newName) {
		name.sendKeys(newName);	
		return this;
	}
	public ManageDeliveryBoyPage newEmail(String newEmail) {
		email.sendKeys(newEmail);
		return this;
	}
	public ManageDeliveryBoyPage phoneNo(String phoneNumber) {
		phone.sendKeys(phoneNumber);
		return this;
	}
	public ManageDeliveryBoyPage newAddress(String newAddress) {
		address.sendKeys(newAddress);
		return this;
	}
	
	public ManageDeliveryBoyPage enterUsername(String newuUsername) {
		userName.sendKeys(newuUsername);
		return this;
	}
	
	public ManageDeliveryBoyPage enterPassword(String newPassword) {
		password.sendKeys(newPassword);
		return this;
	}
	public ManageDeliveryBoyPage saveButton() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", saveButton);
	    return this;
	}
	public boolean verifyDeliveryBoyCreatedSuccessfully() {
	    return alertMessege.isDisplayed();
	}
	public ManageDeliveryBoyPage searchButton() {
		searchButton.click();
		return this;
	}
	public ManageDeliveryBoyPage nameForSearching(String searchName) {
		searchingName.sendKeys(searchName);
		return this;
	}
	public ManageDeliveryBoyPage emailForSearching(String searchEmail) {
		searchingEmail.sendKeys(searchEmail);
		return this;
	}
	public ManageDeliveryBoyPage phNoForSearching(String searchPhone) {
		searchingPhNo.sendKeys(searchPhone);
		return this;
	}
	public ManageDeliveryBoyPage clickSearch() {
		clickSearchButton.click();
		return this;
	}
	public String verifySearchedUsername() {
        return searchedName.getText();
	}
	

}
