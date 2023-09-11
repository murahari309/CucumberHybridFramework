package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement LoginWarningmsg;
	
	
	public void EnterEmailField(String emailtext) {
		elementutils.TypeTextIntoElement(emailfield, emailtext, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public void EnterPasswordField(String password) {
		elementutils.TypeTextIntoElement(passwordfield, password, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public AccountPage ClickOnLoginButton() {
		elementutils.clickOnElement(LoginButton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		return new AccountPage(driver);
		
	}
	public String loginwarningmsg() {
		return elementutils.getText(LoginWarningmsg, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
}
