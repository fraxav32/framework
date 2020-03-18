package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementHelper {
	private Logger logger = Logger.getLogger(ElementHelper.class);
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	public ElementHelper(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	public WebElement findElementCSS(WebDriver driver,By csselement){
		WebElement element=null;
		try{
			if(driver.findElement(csselement).isDisplayed()){
				element= driver.findElement(csselement);
			}
			element= waitHelper.fluentWait(driver,csselement);
			}catch(Exception e){
				logger.error("Unable to launch URL: " + e.getMessage());
				Assert.assertNull(e);
				}
		return element;
		}
}
