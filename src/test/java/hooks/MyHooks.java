package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	 WebDriver driver;
	private ConfigReader reader;
	private DriverFactory dfactory;
	
	@Before
	public void setup() {
		
		 reader = new ConfigReader();
		Properties prop = reader.intializeProperties();
		
		 dfactory = new DriverFactory();
		driver=dfactory.Intializebrowser(prop.getProperty("browser"));
		
		driver.get(prop.getProperty("url"));
		
		

	}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenarioname = scenario.getName().replace(" ", "_");
		if(scenario.isFailed()) {
			
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioname);
		}
		
		driver.quit();
	}

}
