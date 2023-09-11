package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementsutils ;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropDownMenu;
	
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement Registeroption;
	
	@FindBy(name="search")
	private WebElement searchboxfield;
	
	@FindBy(xpath="(//button[contains(@class,'btn-lg')])[1]")
	private WebElement searchboxbutton;
	
	public void ClickonMyAccount() {
		
		elementsutils.clickOnElement(MyAccountDropDownMenu, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public LoginPage ClickonLoginOption() {
		elementsutils.clickOnElement(LoginOption, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		return new LoginPage(driver);
	}
	public RegisterPage clickonregister() {
		elementsutils.clickOnElement(Registeroption, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		return new RegisterPage(driver);
	}
	public void entertextintosearchboxfield(String validproduct) {
		elementsutils.TypeTextIntoElement(searchboxfield, validproduct, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public SearchResults clickonsearchboxbutton() {
		elementsutils.clickOnElement(searchboxbutton, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		return new SearchResults(driver);
	}

}
