package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public  Properties intializeProperties() {
		
		Properties prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
		FileInputStream f = new FileInputStream(propfile);
		prop.load(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
