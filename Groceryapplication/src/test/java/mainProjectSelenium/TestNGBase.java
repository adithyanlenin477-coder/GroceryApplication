package mainProjectSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtilities;

public class TestNGBase {
	public WebDriver driver;
	Properties po;
	FileInputStream fs;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException {
		po=new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		po.load(fs);
		if(browsers.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.get(po.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtilities screenshotutility=new ScreenshotUtilities();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}
	

}
