package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper {
	private WebDriver driver;
	private WebElement ele;
	private Select select;
	private Logger logger = Logger.getLogger(SelectHelper.class);
	
	public SelectHelper(WebDriver driver){
		this.driver = driver;
	}

	public void selectVisibleText(WebElement ele, String data) {
		select = new Select(ele);
		select.selectByVisibleText(data);
	}
	
	public void deselectVisibleText(WebElement ele, String data) {
		select = new Select(ele);
		select.deselectByVisibleText(data);;
	}
	
	public void selectIndex(WebElement ele, int data) {
		select = new Select(ele);
		select.selectByIndex(data);
	}
	
	public void deselectIndex(WebElement ele, int data) {
		select = new Select(ele);
		select.deselectByIndex(data);
	}
	
	public void selectValue(WebElement ele, String data) {
		select = new Select(ele);
		select.selectByValue(data);
	}
	
	public void deselectValue(WebElement ele, String data) {
		select = new Select(ele);
		select.deselectByValue(data);
	}
}
