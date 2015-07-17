package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.CommonComponents;

/*
 * This will have all the page specific components.
 * Page Object Model is used to define the elements
 */
public class GoogleSearchLandingPage extends CommonComponents{
	
	/*
	 * WebElements on the search page are defined here.
	 * @FindBy annotation is used to find the element.
	 */
	@FindBy(how = How.ID, using = "lst-ib")
	private WebElement searchTextBox;
	
	@FindBy(how = How.ID, using = "sblsbb")
	private WebElement searchButton;
	
	//This is to initialize the WebDrive
	public GoogleSearchLandingPage(WebDriver driver) {
		super(driver);
	}
	
	//This is the method which performs an action on the element
	public GoogleSearchLandingPage input_Search(String searchTerm) {
		searchTextBox.sendKeys(searchTerm);
		return this;
	}
	
	//To click on the search button
	public GoogleSearchLandingPage click_Search_Button() {
		searchButton.click();
		return this;
	}
	
}
