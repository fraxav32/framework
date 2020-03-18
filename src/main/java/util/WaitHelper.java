package util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitHelper {
	private Logger logger = Logger.getLogger(WaitHelper.class);
	private WebDriver driver;
	WebDriverWait explicitWait;
	Wait fluentWait;
	ConfigFileReader configFileReader;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		configFileReader = new ConfigFileReader();
	}

	// implicitlyWait set as company standards(It can be change in config file)
	public WebDriver implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}

	public boolean waitForVisibleElement(WebElement ele, long timeUnit) throws Exception {
		boolean iswaitForVisibleElement = false;
		try {
			explicitWait = new WebDriverWait(driver, timeUnit);
			explicitWait.until(ExpectedConditions.visibilityOf(ele));
			iswaitForVisibleElement = true;
		} catch (Exception e) {
			logger.error("Element is not visible: " + ele, e);
			throw new Exception("Element is not visible: " + ele, e);
		}
		return iswaitForVisibleElement;
	}

	public boolean waitForVisibleElement(List<WebElement> ele, long timeUnit) throws Exception {
		boolean iswaitForVisibleElement = false;
		try {
			explicitWait = new WebDriverWait(driver, timeUnit);
			explicitWait.until(ExpectedConditions.visibilityOfAllElements(ele));
			iswaitForVisibleElement = true;
		} catch (Exception e) {
			logger.error("List of element is not visible: " + ele, e);
			throw new Exception("List of element is not visible: " + ele, e);
		}
		return iswaitForVisibleElement;
	}

	public boolean waitForTextElement(WebElement ele, String data, long timeUnit) throws Exception {
		boolean iswaitForTextElement = false;
		try {
			explicitWait = new WebDriverWait(driver, timeUnit);
			explicitWait.until(ExpectedConditions.textToBePresentInElement(ele, data));
			iswaitForTextElement = true;
		} catch (Exception e) {
			logger.error("Element is not visible: " + ele, e);
			throw new Exception("Text is not visible: " + ele, e);
		}
		return iswaitForTextElement;
	}

	public boolean waitForClickableElement(WebElement ele, String data, long timeUnit) throws Exception {
		boolean waitForClickableElement = false;
		try {
			explicitWait = new WebDriverWait(driver, timeUnit);
			explicitWait.until(ExpectedConditions.elementToBeClickable(ele));
			waitForClickableElement = true;
		} catch (Exception e) {
			logger.error("Element is not visible: " + ele, e);
			throw new Exception("Text is not visible: " + ele, e);
		}
		return waitForClickableElement;
	}

	public boolean waitForSelectedElement(WebElement ele, String data, long timeUnit) throws Exception {
		boolean iswaitForSelectedElement = false;
		try {
			explicitWait = new WebDriverWait(driver, timeUnit);
			explicitWait.until(ExpectedConditions.elementToBeSelected(ele));
			iswaitForSelectedElement = true;
		} catch (Exception e) {
			logger.error("Element is not visible: " + ele, e);
			throw new Exception("Text is not visible: " + ele, e);
		}
		return iswaitForSelectedElement;
	}

	public boolean waitForElement(WebElement ele, long timeUnit, long pollingTimeUnit) throws Exception {
		boolean iswaitForSelectedElement = false;
		try {
			fluentWait = new FluentWait<WebDriver>(driver).withTimeout(timeUnit, TimeUnit.SECONDS)
					.pollingEvery(pollingTimeUnit, TimeUnit.SECONDS).ignoring(Exception.class);
			WebElement foo = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return ele;
				}
			});
			iswaitForSelectedElement = true;
		} catch (Exception e) {
			logger.error("Element is not visible: " + ele, e);
			throw new Exception("Text is not visible: " + ele, e);
		}
		return iswaitForSelectedElement;
	}
	
	@SuppressWarnings("deprecation")
	public WebElement fluentWait(WebDriver driver,By csselement){
		WebElement element=null;
		try{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
					.withTimeout(30, TimeUnit.SECONDS) 			
					.pollingEvery(5, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);
			
			element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement element = driver.findElement(csselement);
					if(element.isDisplayed())
						{
						return element;
						}
					return element=null;
					}
				});
				}catch(Exception e){
					logger.error("Unable to find element"+ csselement.toString() +" after 30 second: " + e.getMessage());
					Assert.assertNull(e);
		}
		return element;
	}
}
