package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@class,'btn-danger')]//i[contains(@class,'fa-edit')]")WebElement editButton;
	@FindBy(xpath="//textarea[@id='news']")WebElement addNews;
	@FindBy(xpath="//button[@name='create']")WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]//h5")WebElement successMessage;
	@FindBy(xpath="//a[normalize-space()='Search']")WebElement searchNews;
	@FindBy(xpath="//input[@name='un']")WebElement newsTitle;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]")WebElement searchedNews;
	
	
	public ManageNewsPage clickEdit() {
		editButton.click();
		return this;
	}
	public ManageNewsPage addNews(String addingNews) {
		addNews.sendKeys(addingNews);
		return this;
	}
	public ManageNewsPage clickSave() {
		saveButton.click();
		return this;
	}
	public boolean verifyNewsWasCreatedSuccessfully() {
	    return successMessage.isDisplayed();
	}
	public ManageNewsPage clickSearch() {
		searchNews.click();
		return this;
	}
	public ManageNewsPage searchNews(String newsforSearching) {
		newsTitle.sendKeys(newsforSearching);
		return this;
	}
	public ManageNewsPage clickSearchButton() {
		searchButton.click();
		return this;
		
	}
	public String verifySearchedNews() {
	    return searchedNews.getText();
	}

}
