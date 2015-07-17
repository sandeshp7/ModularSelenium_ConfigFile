package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.GoogleSearchLandingPage;
import framework.BasePage;

public class GoogleSearchTests extends BasePage{
	
	/*
	 * Test methods should be added with @Test annotation.
	 * Its good to name the tests clearly
	 */
	@Test
	public void TestGoogleSearch() {
		//Creating an instance of the page component class using PageFactory
		GoogleSearchLandingPage googleSearchLandingPage = PageFactory.initElements(getDriver(),
				GoogleSearchLandingPage.class);
		
		//This is where the action is performed
		googleSearchLandingPage.input_Search("Selenium");
		
		googleSearchLandingPage.click_Search_Button();
		
		googleSearchLandingPage.verifyByLinkText("Selenium - Web Browser Automation");
		
	}
}
