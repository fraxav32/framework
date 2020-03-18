package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.ProjectConstent;
import dataProvider.DataJSONReader;
import pages.LoginPage;
import pagesdata.LoginPageData;


public class Login extends TestBase{
	private LoginPage loginPage;
	private List<Object> gponData = new ArrayList<>();
	private DataJSONReader jsonDataProvider;
	private Class classToMap = LoginPageData.class;
	private Logger logger = Logger.getLogger(Login.class);
	@Test
	public void testLogin(){
		boolean istestLogin = false;
		loginPage = new LoginPage(driver);
		try{
			if(loginPage.enterLoginCred()){
				istestLogin = true;
			}
			
		}catch(Exception e){
			logger.error("Unable to Login to the Application", e);
		}
		Assert.assertTrue(istestLogin, "Login Test Passed");
	}
	
	
	
	@DataProvider(name = "CreateCompleteServiceData")
	private Iterator<Object> getCreateCompleteServiceData() {
		jsonDataProvider = new DataJSONReader();
		gponData = jsonDataProvider.readJsonDataList(ProjectConstent.JSON_Path + "gPONService\\CreateGPONService.json",
				classToMap, "CreateGPONService");
		return gponData.iterator();
	}
}
