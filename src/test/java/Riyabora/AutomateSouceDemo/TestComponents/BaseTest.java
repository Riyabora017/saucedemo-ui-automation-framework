package Riyabora.AutomateSouceDemo.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import Riyabora.AutomateSouceDemo.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")
				+ "\\src\\main\\java\\Riyabora\\AutomateSouceDemo\\resource\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();

		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--incognito");

		        driver = new ChromeDriver(options);
					}
			else if(browserName.equalsIgnoreCase("firefox")) {
					//firefox
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
			//Edge
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}else {
			    throw new RuntimeException("Invalid browser name");
			}
		//.............................

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	public String getScreensshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
	    File file =new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source,file);
		return  System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException{
		String jsonContent = FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue( jsonContent,new TypeReference<List<HashMap<String, String>>>() {
	    	  
	     });
		return data;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
}
