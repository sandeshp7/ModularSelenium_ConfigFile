package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonComponents {
	private WebDriver driver;

	//This is to initialize the WebDrive
	public CommonComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	//To verify by text of the link
	public Boolean verifyByLinkText(String linkText) {
		return this.driver.findElements(By.linkText(linkText)).size()>0;
	}
		
	//wait for a specified amount of time
	public void waitForTime(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
