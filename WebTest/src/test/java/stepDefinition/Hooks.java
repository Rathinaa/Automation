package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import libraries.ReusableLibrary;
import utilities.Drivermanager;
import utilities.ExtentReportManager;

public class Hooks extends Drivermanager {
	ExtentReportManager extentreport = new ExtentReportManager();
	ReusableLibrary reuse = new ReusableLibrary();
	@Before
    public void beforeScenario(Scenario scenario){
        System.out.println("Scenario name is "+scenario.getName());
        extentreport.invokeReport(scenario.getName());
    } 
 
	@After(order=1)
    public void afterScenario(Scenario scenario) throws Exception{
		if(scenario.isFailed()) {
		String ScreenshotName = scenario.getName().replaceAll(" ", "_");
		System.out.println("Inside Filed Hooks of "+ScreenshotName);
		reuse.getScreenshot(driver, System.getProperty("user.dir") + "\\Reports\\Screenshots\\"+ScreenshotName+".png");
		}
    }
	
	@After(order=0)
    public void afterScenario() throws Exception{
		extentreport.tearReport();
		driver.quit();
    }
}
