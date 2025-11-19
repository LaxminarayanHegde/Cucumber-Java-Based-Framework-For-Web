package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDef {
	
	TestContextSetup testContextSetup;
	
	public OffersPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Then("user searches same shortname on offers page to validate {string} exists or not")
	public void user_searches_same_shortname_on_offers_page_to_validate_exists_or_not(String productName) {
		OffersPage offersPage = testContextSetup.pageObjectManager.getOfferPage();
		offersPage.clickTopDealsButton();
		testContextSetup.genericUtils.switchToChildWindow();
		offersPage.enterTextOnSearchProductInputTextBox(testContextSetup.productShortName);
		String productNameOnOfferPage = offersPage.getProductNameFromOfferPage(productName);
		Assert.assertEquals(productNameOnOfferPage, testContextSetup.productNameOnHomePage);
	}
}
