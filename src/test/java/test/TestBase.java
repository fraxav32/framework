package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constant.ProjectConstent;
import util.ConfigFileReader;
import util.WaitHelper;

public class TestBase {
	private Logger logger = Logger.getLogger(TestBase.class);
	public WebDriver driver = null;
	ConfigFileReader configFileReader;

	// Launch driver for Chrome browser
	public WebDriver chrome() {
		System.setProperty("webdriver.chrome.driver", ProjectConstent.DRIVER_RESOURCE + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.info("Chrome Browser is up and Running");
		return driver;
	}

	// Launch driver for FireFox browser
	public WebDriver fireFox() {
		System.setProperty("webdriver.gecko.driver", ProjectConstent.DRIVER_RESOURCE + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Firefox Browser is up and Running");
		return driver;
	}

	// Launch driver for InternetExplorer browser
	/*
	 * public WebDriver internetExplorer(){ configFileReader= new
	 * ConfigFileReader(); System.setProperty("webdriver.ie.driver",
	 * configFileReader.getDriverPath("internetExplorer")); WebDriver driver= new
	 * InternetExplorerDriver();
	 * log.info("InternetExplorer Browser is up and Running"); return driver; }
	 */

	// Launch Url in the browser and it can be change from config file
	public void launchUrl() {
		configFileReader = new ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
		logger.info("launching the URL");
	}

	// maximizing the browser application
	public WebDriver maximize(WebDriver driver) {
		driver.manage().window().maximize();
		logger.info("Maximize the browser window");
		return driver;
	}

	// closing the application
	public void close(WebDriver driver) {
		driver.close();
		logger.info("Driver is close");
	}

	// closing the application
	public void quit(WebDriver driver) {
		driver.quit();
		logger.info("Driver is quit");
	}

	@BeforeMethod
	public void beforeMethod() {

		// Launch the driver or browser
		try {
			driver = chrome();
		} catch (Exception e) {
			logger.error("driver not initilase: " + e.getMessage());
			Assert.assertNotEquals(null, driver);
		}

		// Launch the URL
		try {
			launchUrl();
		} catch (Exception e) {
			logger.error("Unable to launch URL: " + e.getMessage());
			Assert.assertNull(e);
		}
		maximize(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.implicitlyWait();
	}

	// @AfterMethod
	// public void afterMethod(){
	// ut.close(driver);
	// }
}
