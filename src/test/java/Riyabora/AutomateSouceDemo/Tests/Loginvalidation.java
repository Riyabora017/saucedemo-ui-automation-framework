package Riyabora.AutomateSouceDemo.Tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Riyabora.AutomateSouceDemo.TestComponents.BaseTest;
import Riyabora.AutomateSouceDemo.TestComponents.Retry;
import Riyabora.AutomateSouceDemo.pageobjects.ProductCatalogue;

public class Loginvalidation extends BaseTest  {
   
	@Test(dataProvider="getData", dataProviderClass = SubmitOrder.class, groups={"Regression"})
	public void loginErrorTest(HashMap<String,Object> input) {
		Map<String, String> login =(Map<String, String>) input.get("login");

        // ---------------- ORDER DATA ----------------
        Map<String, String> order =(Map<String, String>) input.get("order");
        Map<String, String>loginerror =(Map<String, String>) input.get("loginerror");
        

		ProductCatalogue productCatalogue =  loginPage.loginApplication(loginerror.get("username"),login.get("password"));
	    String errorMessage=driver.findElement(By.tagName("h3")).getText();
	    System.out.println(errorMessage);
	    Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
	}
	
	
	@Test(dataProvider="getData", dataProviderClass=SubmitOrder.class,groups= {"Regression"})
	public void loginSuccessfulTest(HashMap<String,Object>input){
		Map<String,String>login =(Map<String,String>) input.get("login");
		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
		String confirmlogin=driver.findElement(By.cssSelector("span[class='title']")).getText();
		  System.out.println(confirmlogin);
		  Assert.assertEquals(confirmlogin, "Products");
	}
	
	@Test(dataProvider="getData", dataProviderClass=SubmitOrder.class,groups= {"Regression"}, retryAnalyzer=Retry.class)
	public void failedTest(HashMap<String,Object>input){
		Map<String,String>login =(Map<String,String>) input.get("login");
		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
		 String errorMessage=driver.findElement(By.tagName("h3")).getText();
		    System.out.println(errorMessage);
		    Assert.assertEquals(errorMessage,"Epic Username and password do not match any user in this service");
	}}
	