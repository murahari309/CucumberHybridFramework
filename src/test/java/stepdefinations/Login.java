package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage login;
	private AccountPage account;
	private CommonUtils common;
	private DriverFactory dfactory;


	@Given("^user has navigates login page$")
	public void user_has_navigates_login_page() {
		 dfactory = new DriverFactory();
		driver=dfactory.GetDriver();
		HomePage home = new HomePage(driver);
		home.ClickonMyAccount();
		login=home.ClickonLoginOption();

	}

	@When("^User entered valid Emailaddress (.+) into the emailfield$")
	public void User_entered_valid_Emailaddress_into_the_emailfield(String email) {
		 
		login.EnterEmailField(email);	
	}

	@And("^User entered valid Password (.+) into the passwordfield$")
	public void User_entered_valid_Password_into_the_passwordfield(String password) {
		
		login.EnterPasswordField(password);
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		
		 account = login.ClickOnLoginButton();

		
	}

	@Then("^user should be able to successfully logged in$")
	public void user_should_be_able_to_successfully_logged_in() {
		
		Assert.assertTrue(account.verify_edityouraccountinforamationoption());

	}

	@When("^user entered invalid Emailaddress into the emailfield$")
	public void user_entered_invalid_Emailaddress_into_the_emailfield() {
		 common = new CommonUtils();
		login.EnterEmailField(common.GetEmailWithTimeStamp());
	}

	@And("^user entered invalid Password \"(.+)\" into the passwordfiled$")
	public void user_entered_invalid_Password_into_the_passwordfiled(String invalidpassword) {
		login.EnterPasswordField(invalidpassword);

		
	}

	@Then("^user should get a proper warning message about credentials missmatch$")
	public void user_should_get_a_proper_warning_message_about_credentials_missmatch() {


		Assert.assertTrue(login.loginwarningmsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@And("^user entered invalid password \"(.+)\" into passwordfield$")
	public void user_entered_invalid_password_into_passwordfield(String invalidpassword) {
		login = new LoginPage(driver);
		login.EnterPasswordField(invalidpassword);

		
	}

	@When("^user dont enter emailaddress into the emailfield$")
	public void user_dont_enter_emailaddress_into_the_emailfield() {
		
		login.EnterEmailField("");
	}

	@And("user dont enter password into the passwordfield")
	public void user_dont_enter_password_into_the_passwordfield() {
		login.EnterPasswordField("");
		

	}
	
	

}
