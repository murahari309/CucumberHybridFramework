package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResults {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public SearchResults(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validproduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noproductwarning;
	
	public boolean validproduct() {
		return elementutils.DisplayStatusofElement(validproduct, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
	}
	public String noproductwarning() {
		return elementutils.getText(noproductwarning, CommonUtils.EXPLICIT_WAIT_BASE_TIME);
		
		
		
	}
	
	
}
