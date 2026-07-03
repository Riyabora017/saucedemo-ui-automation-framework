package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

	WebDriver driver;
	
        public CheckoutOverviewPage(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
       @FindBy(id="finish")
       WebElement finishBtn;
       
   
       public OrderConfirmationPage CompleteOrder() {
    	finishBtn.click();
    	OrderConfirmationPage orderconfirmationpage = new OrderConfirmationPage(driver);	
        return orderconfirmationpage;
       }
    	
    
        
}


