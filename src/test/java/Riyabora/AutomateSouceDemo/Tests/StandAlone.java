package Riyabora.AutomateSouceDemo.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	@Test(groups={"Smoke"})
	public void StandAloneTest() throws InterruptedException {
		// TODO Auto-generated method st
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// add to cart item
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();
		driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
		driver.findElement(By.cssSelector("#checkout")).click();
		// add info cart confirmation page
		driver.findElement(By.id("first-name")).sendKeys("Riya");
		driver.findElement(By.id("last-name")).sendKeys("Bora");
		driver.findElement(By.id("postal-code")).sendKeys("201315");
		driver.findElement(By.cssSelector("#continue")).click();
		// checkout page
		WebElement element = driver.findElement(By.id("finish"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		element.click();
//orderconfirmation page
		
		String message =driver.findElement(By.tagName("h2")).getText();
		System.out.println(message);
		driver.quit();
	}

}
