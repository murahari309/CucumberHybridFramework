package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountSuccessPage {
	WebDriver driver;
	private ElementUtils elementutils;
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils = new ElementUtils(driver);
	}

	@FindBy(xpath="(//div[@id='content']/p)[1]")
	private WebElement pageheading;
	
	public String successpageheadingtext() {
		
		return elementutils.getText(pageheading, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
	}
}
