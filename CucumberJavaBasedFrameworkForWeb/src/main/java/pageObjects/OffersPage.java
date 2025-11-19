package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtils;

public class OffersPage extends ElementUtils{
	WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By topDealsButton = By.linkText("Top Deals");
	private By searchProductInputTextBox = By.xpath("//input[@type='search']");
	
	public void clickTopDealsButton() {
		clickElement(topDealsButton, driver, 10);
	}
	
	public void enterTextOnSearchProductInputTextBox(String productName) {
		enterTextOnInputTextField(searchProductInputTextBox, driver, 10, productName);
	}
	
	public String getProductNameFromOfferPage(String productName) {
		WebElement productOnOfferPage = driver.findElement(By.xpath("//tr/td[text()='" + productName + "']"));
		return productOnOfferPage.getText();
	}
	
}
