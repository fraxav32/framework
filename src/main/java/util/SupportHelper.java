package util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import constant.ProjectConstent;


public class SupportHelper {
	ConfigFileReader configFileReader;
	private Logger logger = Logger.getLogger(SupportHelper.class);
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	public SupportHelper(WebDriver driver){
		this.driver = driver;
		configFileReader= new ConfigFileReader();
		waitHelper = new WaitHelper(driver);
	}		
	
	//for taking the screenshot
	public WebDriver captureScreenMethod(WebDriver driver){
		try{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
		}
		catch(IOException e){
			logger.error("not able to generate file" + e.getMessage());
		}
		return driver;
	}
	
	
}
