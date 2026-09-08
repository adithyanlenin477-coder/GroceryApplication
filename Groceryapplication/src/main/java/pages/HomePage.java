package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@class,'nav-link')]//img[@alt='User Image']")WebElement adminImage;
	@FindBy(xpath = "//a[contains(@href,'/admin/logout')]")WebElement logout;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminUsers;
	@FindBy(xpath="//a[contains(@href,'list-deliveryboy') and normalize-space()='More info']")WebElement deliveryBoy;
	@FindBy(xpath="//a[contains(@href,'list-news') and normalize-space()='More info']")WebElement manageNewsClick;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement sevenmart;
	
	
	public HomePage clickAdmin() {
		adminImage.click();
		return this;
	}
	public LoginPage clickLogOut() {
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUserPage clickAdminUsers() {
		adminUsers.click();
		return new AdminUserPage(driver);
	}
	public ManageDeliveryBoyPage clickDeliveryBoy() {
		deliveryBoy.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public ManageNewsPage clickManageNews() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", manageNewsClick);
	    return new ManageNewsPage(driver);
	}
	public String verifyLogintextisDisplayed() {
		return sevenmart.getText();
	}

}
