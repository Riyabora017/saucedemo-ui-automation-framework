package Riyabora.AutomateSouceDemo.Tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Riyabora.AutomateSouceDemo.TestComponents.BaseTest;
import Riyabora.AutomateSouceDemo.pageobjects.CartPage;
import Riyabora.AutomateSouceDemo.pageobjects.ProductCatalogue;

public class CartPageValidation extends BaseTest {
	
		@Test(dataProvider="getData",dataProviderClass=SubmitOrder.class,groups= {"Regression"})
	public void cartItemValidation(HashMap<String,Object>input) {
    	
		Map<String, String> login =(Map<String, String>) input.get("login");
		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
		productCatalogue.addItemtocart();
		CartPage cartPage= productCatalogue.openCart();
	    String verifyItem=driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
	    System.out.println(verifyItem);
	    Assert.assertEquals(verifyItem, "Sauce Labs Backpack");
	}
		@Test(dataProvider="getData",dataProviderClass=SubmitOrder.class,groups= {"Regression"})
		public void cartEmptyValidation(HashMap<String,Object>input) {
			Map<String, String> login =(Map<String, String>) input.get("login");
			ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
			CartPage cartPage= productCatalogue.openCart();

		    List<WebElement> cartItems =
		            driver.findElements(By.cssSelector(".cart_item"));
	     System.out.println(cartItems);
		    Assert.assertEquals(cartItems.size(), 0);
		}
}
