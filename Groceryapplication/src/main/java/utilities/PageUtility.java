package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByValue(value);

		}
	
	public void selectByVisbleText(WebElement element, String text) {

		Select object=new Select(element);

		object.selectByVisibleText(text);

		}
	
	public void selectByIndex(WebElement element) {

		Select object=new Select(element);

		object.selectByIndex(0);

		}
	
	
	public void jsClick(WebElement element,WebDriver driver) {

	    JavascriptExecutor object = (JavascriptExecutor) driver;

	    object.executeScript("arguments[0].click();", element);

	}
	
	public void scrollDown(WebDriver driver) {

	    JavascriptExecutor object = (JavascriptExecutor) driver;

	    object.executeScript("window.scrollBy(0,500);");

	}
	
	//Mouse Actions
	
	public void mouseHover(WebElement element,WebDriver driver) {
	    Actions object = new Actions(driver);
	    object.moveToElement(element).perform();
	}
	
	
	public void rightClick(WebElement element,WebDriver driver) {
	    Actions object = new Actions(driver);
	    object.contextClick(element).perform();
	}
	
	public void doubleClick(WebElement element,WebDriver driver) {
	    Actions object = new Actions(driver);
	    object.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement target,WebDriver driver) {
	    Actions object = new Actions(driver);
	    object.dragAndDrop(source, target).perform();
	}
	

}
