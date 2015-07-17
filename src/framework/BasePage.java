package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BasePage {
	private WebDriver driver = null;
	private Properties properties = new Properties();
	private InputStream input = null;
	private String browser;
	private String autURL;
	private long webDriverWaitTime;
	
	public BasePage() {
		try {
			//Read the config file
			input = new FileInputStream("resources/config.properties");
			
			//Load the file
			properties.load(input);
			
			//Can access the properties with the key
			browser = properties.getProperty("BROWSER");
			autURL = properties.getProperty("AUT_URL");
			webDriverWaitTime = Long.parseLong(properties.getProperty("IMPLICIT_WAIT"));
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	//Getter method for the webDriver
	public WebDriver getDriver() {
		return this.driver;
	}

	/*
	 * This method will always be executed before every test method.
	 * The browser will be launched for each test. 
	 */
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		// Runs on Chrome.
		driver = getBrowser();
		//This is the wait time when trying to find an element or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(webDriverWaitTime, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(autURL);
	}

	/*
	 * This method will always be executed after every test method.
	 * The browser will be closed after each test. 
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}
	
	//Can specify any number of drivers here.
	private WebDriver getBrowser() {
		switch(browser) {
			case "chrome" :
				return new ChromeDriver();
			case"firefox" :
				return new FirefoxDriver();
			default:
				return new ChromeDriver();
		}
	}
	
	

}