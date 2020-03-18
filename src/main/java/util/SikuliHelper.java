package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliHelper {
	private WebDriver driver;
	private Screen screen;
	private Logger logger = Logger.getLogger(SikuliHelper.class);
	
	public SikuliHelper(WebDriver driver){
		this.driver = driver;
		screen = new Screen();
	}
	
	public boolean waitAndFind(Pattern screenData) {
		try {
			screen.wait(screenData, 20);
			logger.info("Pattern found"+screenData.getFilename());
			return true;
		} catch (FindFailed e) {
			logger.info("Pattern not found"+screenData.getFilename());
			return false;
		}
	}
	
	public boolean waitAndClick(Pattern screenData) throws Exception {
		try {
			if(waitAndFind(screenData)) {
				screen.click(screenData);
				logger.info("Pattern is clicked: "+screenData.getFilename());
				return true;
			}
		} catch (FindFailed e) {
			logger.info("Pattern not found: "+screenData.getFilename());
			throw e;
		} catch (Exception e) {
			logger.error("failure in waitAndClick: "+e);
			throw new Exception("failure in waitAndClick: "+e);
		}
		return false;
	}
	
	public boolean waitAndDoubleClick(Pattern screenData) throws Exception {
		try {
			if(waitAndFind(screenData)) {
				screen.doubleClick(screenData);
				logger.info("Pattern is double clicked: "+screenData.getFilename());
				return true;
			}
		} catch (FindFailed e) {
			logger.info("Pattern not found: "+screenData.getFilename());
			throw e;
		} catch (Exception e) {
			logger.error("failure in waitAndDoubleClick: "+e);
			throw new Exception("failure in waitAndDoubleClick: "+e);
		}
		return false;
	}
	
	public boolean waitAndType(Pattern screenData, String messageData) throws Exception {
		try {
			if(waitAndFind(screenData)) {
				screen.type("");
				screen.type(screenData, messageData);
				logger.info("Text is entered in textbox: "+screenData.getFilename());
				return true;
			}
		} catch (FindFailed e) {
			logger.info("Pattern not found: "+screenData.getFilename());
			throw e;
		} catch (Exception e) {
			logger.error("failure in waitAndType: "+e);
			throw new Exception("failure in waitAndType: "+e);
		}
		return false;
	}
	
	public boolean waitAndHover(Pattern screenData) throws Exception {
		try {
			if(waitAndFind(screenData)) {
				screen.hover(screenData);
				logger.info("Pattern is mouse hover: "+screenData.getFilename());
				return true;
			}
		} catch (FindFailed e) {
			logger.info("Pattern not found: "+screenData.getFilename());
			throw e;
		} catch (Exception e) {
			logger.error("failure in waitAndHover: "+e);
			throw new Exception("failure in waitAndHover: "+e);
		}
		return false;
	}
	
}
