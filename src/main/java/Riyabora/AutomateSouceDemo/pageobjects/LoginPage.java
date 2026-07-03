package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
        public LoginPage(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
        @FindBy(id="user-name")
        WebElement username;
        
        @FindBy(id="password")
        WebElement userpassword;
        
        @FindBy(id="login-button")
        WebElement login;
        
        public ProductCatalogue loginApplication(String userName,String password) {
        	username.sendKeys(userName);
        	userpassword.sendKeys(password);
        	login.click();
        	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        	return productCatalogue;
        	
        }
        
public void goTo() {
	driver.get("https://www.saucedemo.com/");
}
        
	}


