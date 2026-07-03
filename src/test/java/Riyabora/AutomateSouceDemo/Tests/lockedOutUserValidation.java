package Riyabora.AutomateSouceDemo.Tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Riyabora.AutomateSouceDemo.TestComponents.BaseTest;
import Riyabora.AutomateSouceDemo.pageobjects.CartPage;
import Riyabora.AutomateSouceDemo.pageobjects.CheckoutInformationPage;
import Riyabora.AutomateSouceDemo.pageobjects.CheckoutOverviewPage;
import Riyabora.AutomateSouceDemo.pageobjects.OrderConfirmationPage;
import Riyabora.AutomateSouceDemo.pageobjects.ProductCatalogue;

public class lockedOutUserValidation extends BaseTest{
	@Test(dataProvider="getData", dataProviderClass=SubmitOrder.class, groups={"Purchase"})
	public void lockedoutTest(HashMap<String,Object>input) {
		Map<String, String> login =(Map<String, String>) input.get("login");

        Map<String, String> order =(Map<String, String>) input.get("order");

		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
	
		productCatalogue.addItemtocart();
		CartPage cartPage= productCatalogue.openCart();
		
		CheckoutInformationPage checkoutinfopage=cartPage.clickCheckout();
		
		checkoutinfopage.enterInfo(order.get("firstName"),order.get("lastName"),order.get("zipCode"));

		CheckoutOverviewPage checkoverviewpage=checkoutinfopage.ContinueOrder();
		
		OrderConfirmationPage orderconfirmationpage=checkoverviewpage.CompleteOrder();
       Assert.assertEquals(orderconfirmationpage.getConfirmationMessage(),"Thank you for your order!");
       driver.findElement(By.cssSelector(".bm-burger-button")).click();	
	    driver.findElement(By.id("logout_sidebar_link")).click();
	    String verifyloginpage=driver.findElement(By.tagName("h4")).getText();
	    System.out.println(verifyloginpage);
	    Assert.assertEquals(verifyloginpage,"Accepted usernames are:");    
	}
	}


