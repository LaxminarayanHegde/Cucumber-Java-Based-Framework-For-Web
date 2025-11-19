package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtils;

public class LandingPage extends ElementUtils{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchProductInputTextBox = By.xpath("//input[@type='search']");
	private By searchButton = By.cssSelector("button.search-button");
	private By nameOfProductOnCard = By.xpath("//h4[contains(text(),'Tom')]");
	
	public void enterTextOnSearchProductInputTextBox(String productName) {
		enterTextOnInputTextField(searchProductInputTextBox, driver, 10, productName);
	}
	
	public void clickSearchButton() {
		clickElement(searchButton, driver, 10);
	}
	
	public String getNameOfProuctOnTheProductCard() {
		return getTextFromElement(nameOfProductOnCard, driver, 10);
	}
	
}
