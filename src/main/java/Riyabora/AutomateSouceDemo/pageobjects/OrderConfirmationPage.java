package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	WebDriver driver;
	
        public OrderConfirmationPage(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
  public By message = By.tagName("h2");
       
   
       public String getConfirmationMessage() {
    	   return driver.findElement(message).getText();
    }
    	
    
        
}


