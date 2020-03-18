package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionHelper {
	private Actions action;
	private Logger logger = Logger.getLogger(ActionHelper.class);
	
	public ActionHelper(WebDriver driver) {
		action = new Actions(driver);
	}
	
	public boolean moveandClick(WebElement ele) {
		boolean ismoveandClick= false;
		if(ele.isDisplayed()) {
			action.moveToElement(ele).click().build().perform();
			ismoveandClick= true;
		}
		return ismoveandClick;
	}
	
	public boolean moveandDoubleClick(WebElement ele) {
		boolean ismoveandDoubleClick= false;
		if(ele.isDisplayed()) {
			action.moveToElement(ele).doubleClick().build().perform();
			ismoveandDoubleClick= true;
		}
		return ismoveandDoubleClick;
	}
	
	public boolean moveandRightClick(WebElement ele) {
		boolean ismoveandRightClick= false;
		if(ele.isDisplayed()) {
			action.moveToElement(ele).contextClick().build().perform();
			ismoveandRightClick= true;
		}
		return ismoveandRightClick;
	}
	
	public boolean rightClick(WebElement ele) {
		boolean isrightClick= false;
		if(ele.isDisplayed()) {
			action.contextClick(ele).build().perform();
			isrightClick= true;
		}
		return isrightClick;
	}
	
	public boolean moveandWrite(WebElement ele, String data) {
		boolean ismoveandWrite= false;
		if(ele.isDisplayed()) {
			action.moveToElement(ele).sendKeys(data).build().perform();
			ismoveandWrite= true;
		}
		return ismoveandWrite;
	}
	
	public boolean write(WebElement ele, String data) {
		boolean iswrite= false;
		if(ele.isDisplayed()) {
			action.sendKeys(ele, data).build().perform();
			iswrite= true;
		}
		return iswrite;
	}
}
