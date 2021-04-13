package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import libraries.ReusableLibrary;

public class Drivermanager extends ReusableLibrary {
	
	public static WebDriver driver;	
	public static String BrowserType;
	String DriverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	
	public WebDriver getDriver() {
	
		try {
			BrowserType = getProperty("Browser");
			switch(BrowserType){
			case("Chrome"):
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
}
