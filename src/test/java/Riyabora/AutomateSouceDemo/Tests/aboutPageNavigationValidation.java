package Riyabora.AutomateSouceDemo.Tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Riyabora.AutomateSouceDemo.TestComponents.BaseTest;
import Riyabora.AutomateSouceDemo.pageobjects.ProductCatalogue;

public class aboutPageNavigationValidation extends BaseTest {

	@Test(dataProvider="getData", dataProviderClass=SubmitOrder.class, groups={"Purchase"})
	public void VerifynavigateaboutpageTest(HashMap<String,Object>input){
		Map<String, String> login =(Map<String, String>) input.get("login");
		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
		driver.findElement(By.cssSelector(".bm-burger-button")).click();	
		 driver.findElement(By.id("about_sidebar_link")).click();
		    String verifyaboutPage=driver.findElement(By.tagName("h1")).getText();
		    System.out.println(verifyaboutPage);
		    Assert.assertEquals(verifyaboutPage,"The World's Only Full-Lifecycle AI-Quality Platform");    
	}

}