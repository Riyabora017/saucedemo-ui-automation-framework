package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {

	WebDriver driver;
	
        public ProductCatalogue(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
        @FindBy(xpath="//div[@class='inventory_item']//button")
        WebElement addtocart;
        
        @FindBy(css="a[class='shopping_cart_link']")
        WebElement cartIcon;
        

        
     public void addItemtocart() {
    	 addtocart.click();
     }
     public CartPage openCart() {
    	 cartIcon.click();
    	 CartPage cartPage = new CartPage(driver);
    	 return cartPage;
     }
        
}


