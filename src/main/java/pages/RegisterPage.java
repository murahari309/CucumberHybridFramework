package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementUtils elementutils;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastnamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordfield;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacypolicybutton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement newsletterbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacypolicywarning ;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnamewarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement Lastnamewarning;
	
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	public void enterfirstname(String firstname) {
		elementutils.TypeTextIntoElement(firstnamefield, firstname,CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}
	public void enterlastname(String lastname) {
		elementutils.TypeTextIntoElement(lastnamefield, lastname, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void enteremail(String email) {
		elementutils.TypeTextIntoElement(emailfield, email, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void entertelephone(String telephone) {
		elementutils.TypeTextIntoElement(telephonefield, telephone, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void enterpassword(String password) {
		elementutils.TypeTextIntoElement(passwordfield, password, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void confirmpassword(String confirmpassword) {
		elementutils.TypeTextIntoElement(confirmPasswordfield, confirmpassword, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void privacypolicybutton() {
		elementutils.clickOnElement(privacypolicybutton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public AccountSuccessPage clickoncontinuebutton() {
		elementutils.clickOnElement(continuebutton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		return new AccountSuccessPage(driver);
	}
	public void clickonnewsletterbutton() {
		elementutils.clickOnElement(newsletterbutton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	
	public String duplicateemail() {
		
		return elementutils.getText(duplicateEmailWarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}
	public String privacypolicywarning() {
		
		return elementutils.getText(privacypolicywarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public String firstnamewarning() {
		return elementutils.getText(firstnamewarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}
	public String lastnamewarning () {
		
		return elementutils.getText(Lastnamewarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public String emailwarning() {
		
		return elementutils.getText(emailwarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
			
	}
	public String telephonewarning() {
		return elementutils.getText(telephonewarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}
	public String passwordwarning() {
		
		return elementutils.getText(passwordwarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}

}
