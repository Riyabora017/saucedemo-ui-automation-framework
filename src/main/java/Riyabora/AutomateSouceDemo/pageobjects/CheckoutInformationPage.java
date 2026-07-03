package Riyabora.AutomateSouceDemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {

	WebDriver driver;
	
        public CheckoutInformationPage(WebDriver driver){
        	this.driver = driver;
        	PageFactory.initElements( driver,this);
        }
        
       @FindBy(id="continue")
       WebElement continueBtn;
       
       public By firstName = By.id("first-name");
       public By lastName = By.id("last-name");
       public By postalCode = By.id("postal-code");
       
       
        
    public void enterInfo(String fName,String lName, String pCode ){
    	driver.findElement(firstName).sendKeys(fName);
    	driver.findElement(lastName).sendKeys(lName);
    	driver.findElement(postalCode).sendKeys(pCode);
    } 
 
    public  CheckoutOverviewPage ContinueOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",continueBtn);

		continueBtn.click();
		CheckoutOverviewPage checkoverviewpage=new CheckoutOverviewPage(driver);
		return checkoverviewpage;
    }
    	
    
        
}


