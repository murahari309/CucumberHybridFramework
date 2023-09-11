package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResults;

public class Search {
	WebDriver driver;
	private HomePage home;
	private SearchResults search;
	private DriverFactory dfactory;
	
	@Given("^user open the application$")
	public void user_open_the_application() {
		 dfactory = new DriverFactory();
		 driver = dfactory.GetDriver();
	    
	}

	@When("user enters valid product {string} into searchbox field")
	public void user_enters_valid_product_into_searchbox_field(String validproduct) {
		 home = new HomePage(driver);
		home.entertextintosearchboxfield(validproduct);
	    
	}

	@When("^user clicks on searchbox button$")
	public void user_clicks_on_searchbox_button() {
		search=home.clickonsearchboxbutton();
	}

	@Then("^user should get valid product displayed in search results$")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		 
		Assert.assertTrue(search.validproduct());
		Assert.fail();
	    
	}

	@When("user enters invalid product {string} into searchbox field")
	public void user_enters_invalid_product_into_searchbox_field(String invalidproduct) {
		home = new HomePage(driver);
		home.entertextintosearchboxfield(invalidproduct);
		

	    
	}

	@Then("^user should get a message about no product matching$")
	public void user_should_get_a_message_about_no_product_matching() {
		
		
	   
	   Assert.assertEquals("There is no product that matches the search criteria.",search.noproductwarning());
	}

	@When("^user dont enter any product name in the searchbox field$")
	public void user_dont_enter_any_product_name_in_the_searchbox_field() {
		 home = new HomePage(driver);
	
	   
	}

}
