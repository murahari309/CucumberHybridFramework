package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnElement(WebElement element,long durationInSeconds) {
		
		
		WebElement web = waitForElement(element,durationInSeconds);
		web.click();
	}
	public void TypeTextIntoElement(WebElement element,String textTobeTyped,long durationInSeconds) {
		
		
		WebElement we = waitForElement(element,durationInSeconds);
		we.click();
		we.clear();
		we.sendKeys(textTobeTyped);
	}
	
	public WebElement waitForElement(WebElement wlement,long durationInSeconds) {
		WebElement welement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		welement=  wait.until(ExpectedConditions.elementToBeClickable(wlement));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return welement;
	}
	
	public void selectoptionIndropdown(WebElement element,String dropdownOption,long durationInSeconds) {
		WebElement welement = waitForElement(element,durationInSeconds);
		Select select = new Select(welement);
		select.selectByVisibleText(dropdownOption);
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitforalert(durationInSeconds);
		alert.accept();
		
	}
	
	public void dismissAlert(long durationInSeconds ) {
		Alert alert = waitforalert(durationInSeconds);
		alert.dismiss();
		
	}
	public Alert waitforalert(long durationInSeconds) {
		
		Alert alert=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void MouseHoverAndClick(WebElement element,long durationInSeconds) {
		
		WebElement welement = WaitForVisibilityofElement(element,durationInSeconds);
		
		Actions action = new Actions(driver);
		action.moveToElement(welement).click().build().perform();
	}
	public WebElement WaitForVisibilityofElement(WebElement element ,long durationInSeconds) {
		WebElement welement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 welement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return welement;
	}
	public void JavaScriptClick(WebElement element,long durationInSeconds) {
		WebElement webele = WaitForVisibilityofElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webele );
		
	}
	public void JavaScriptType(WebElement element,long durationInSeconds,String TextToBeTyped) {
		WebElement webele = WaitForVisibilityofElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+TextToBeTyped+"'",webele );
	}
	public String  getText(WebElement element,long durationInSeconds) {
		WebElement webelement = waitForElement(element,durationInSeconds);
		return webelement.getText();
	}
	public boolean DisplayStatusofElement(WebElement element,long durationInSeconds) {
		try {
		WebElement webelement = WaitForVisibilityofElement(element,durationInSeconds);
		 return webelement.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}
