package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReusableLibrary {

	Properties properties = new Properties();
	public String getProperty(String key) throws IOException {
		
		String value = "";
		
		File file = new File("src//main//resources//configuration.properties");
		InputStream inputstream = new FileInputStream(file);
		properties.load(inputstream);		
		value = (String)properties.getProperty(key);
		
		return value;
	}
	
	public void getScreenshot(WebDriver driver, String Path) throws IOException {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(Path));
	}
	
	public String dateStamp() {

        try {
        	return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
        }
}
