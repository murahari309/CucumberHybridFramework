package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage register;
	private AccountSuccessPage accountsuccess;
	private CommonUtils common;
	private DriverFactory dfactory;

	@Given("^user navigates to RegisterAccount page$")
	public void user_navigates_to_register_account_page() {
		 dfactory = new DriverFactory();
		driver = dfactory.GetDriver();
		HomePage home = new HomePage(driver);
		home.ClickonMyAccount();
		register=home.clickonregister();
	}
	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable datatable) {
		Map<String, String> datamap = datatable.asMap(String.class, String.class);
		register.enterfirstname(datamap.get("FirstName"));
		register.enterlastname(datamap.get("LastName"));
		 common = new CommonUtils();
		register.enteremail(common.GetEmailWithTimeStamp());
		register.entertelephone(datamap.get("Telephone"));
		register.enterpassword(datamap.get("Password"));
		register.confirmpassword(datamap.get("Password"));

	}
	
	@When("user enters the details into below fieldsss")
	public void user_enters_the_details_into_below_fieldss(DataTable datatable) {
		Map<String, String> datamap = datatable.asMap(String.class, String.class);
		
		register.enterfirstname(datamap.get("FirstName"));
		register.enterlastname(datamap.get("LastName"));
		register.enteremail(datamap.get("E-Mail"));
		register.entertelephone(datamap.get("Telephone"));
		register.enterpassword(datamap.get("Password"));
		register.confirmpassword(datamap.get("Password"));
		
		
	}

	@When("^user selects the privacy policy button$")
	public void user_selects_the_privacy_policy_button() {
		register.privacypolicybutton();
	}

	@When("^user clicks on continue button$")
	public void user_clicks_on_continue_button() {
	 accountsuccess = register.clickoncontinuebutton();
	}

	@Then("^user should get a proper warning about duplicate email$")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertEquals("Warning: E-Mail Address is already registered!",register.duplicateemail());

	}

	@Then("^user account should get created successfully$")
	public void user_account_should_get_created_successfully() {
        
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",accountsuccess.successpageheadingtext());
	}

	@When("^user selects yes for newsletter$")
	public void user_selects_yes_for_newsletter() {
		register = new RegisterPage(driver);
		register.clickonnewsletterbutton();
		
		
	}

	@When("^user dont enter any details into fields$")
	public void user_dont_enter_any_details_into_fields() {
        
		//kept it blank

	}

	@Then("^user should get a proper warning messages$")
	public void user_should_get_a_proper_warning_messages() {

		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",register.privacypolicywarning());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",register.firstnamewarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",register.lastnamewarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",register.emailwarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",register.telephonewarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",register.passwordwarning());
	}
	
	

}
