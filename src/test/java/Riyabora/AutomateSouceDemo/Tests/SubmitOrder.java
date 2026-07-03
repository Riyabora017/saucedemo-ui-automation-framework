package Riyabora.AutomateSouceDemo.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Riyabora.AutomateSouceDemo.TestComponents.BaseTest;
import Riyabora.AutomateSouceDemo.data.DataReader;
import Riyabora.AutomateSouceDemo.pageobjects.CartPage;
import Riyabora.AutomateSouceDemo.pageobjects.CheckoutInformationPage;
import Riyabora.AutomateSouceDemo.pageobjects.CheckoutOverviewPage;
import Riyabora.AutomateSouceDemo.pageobjects.OrderConfirmationPage;
import Riyabora.AutomateSouceDemo.pageobjects.ProductCatalogue;

public class SubmitOrder extends BaseTest{

	@Test(dataProvider="getData", groups={"Purchase"})
	public void submitOrderTest(HashMap<String, Object> input) {
		// TODO Auto-generated method st
		Map<String, String> login =(Map<String, String>) input.get("login");

        // ---------------- ORDER DATA ----------------
        Map<String, String> order =(Map<String, String>) input.get("order");

		ProductCatalogue productCatalogue =  loginPage.loginApplication(login.get("username"),login.get("password"));
		// productCatalogue
		productCatalogue.addItemtocart();
		CartPage cartPage= productCatalogue.openCart();
		//cartpage
		CheckoutInformationPage checkoutinfopage=cartPage.clickCheckout();
		// checkoutinfo
		checkoutinfopage.enterInfo(order.get("firstName"),order.get("lastName"),order.get("zipCode"));

		CheckoutOverviewPage checkoverviewpage=checkoutinfopage.ContinueOrder();
		// checkoutoverview
		OrderConfirmationPage orderconfirmationpage=checkoverviewpage.CompleteOrder();
        //orderconfirmation page
		Assert.assertEquals(orderconfirmationpage.getConfirmationMessage(),"Thank you for your order!");
		}
	
	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {

	    DataReader dataReader = new DataReader();

	    List<HashMap<String, Object>> data =
	        dataReader.getJsonDataToMap(
	            System.getProperty("user.dir")
	            + "\\src\\test\\java\\Riyabora\\AutomateSouceDemo\\data\\PurchaseOrder.json"
	        );

	    return data.stream()
	            .map(d -> new Object[]{d})
	            .toArray(Object[][]::new);
	}
}

