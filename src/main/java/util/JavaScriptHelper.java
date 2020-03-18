package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	private WebElement driver;
	private JavascriptExecutor js;
	private Logger logger = Logger.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebElement driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public void scrollDown( ) {
		js.executeScript("window.scrollBy(0,250)");
	}
	
	public void scrollUp( ) {
		js.executeScript("window.scrollBy(0,-250)");
	}
	
	public void clickHiddenElement(WebElement ele) {
		js.executeScript("arguments[0].click();", ele);
	}
	
	public String getHiddenElementText(WebElement ele){
	    return (String) js.executeScript("return jQuery(arguments[0]).text();", ele);
	}

}
