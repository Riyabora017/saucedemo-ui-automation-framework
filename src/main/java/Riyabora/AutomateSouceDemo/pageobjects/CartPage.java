package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
        public CartPage(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
        @FindBy(css="#checkout")
        WebElement checkoutBtn;
        
    public CheckoutInformationPage  clickCheckout() {
    	checkoutBtn.click();
    	CheckoutInformationPage checkoutinfopage =new CheckoutInformationPage(driver);
    	 return checkoutinfopage;
    }
        
}


