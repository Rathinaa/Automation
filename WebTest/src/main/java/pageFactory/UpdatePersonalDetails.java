package pageFactory;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utilities.Drivermanager;
import utilities.ExtentReportManager;

public class UpdatePersonalDetails extends Drivermanager {

	Actions action = new Actions(driver);
	public static WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	ExtentReportManager extentreport = new ExtentReportManager();
	public String OrderID  = "";
	
	public UpdatePersonalDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Information']")
	public WebElement PersonalInformation;
	
	@FindBy(xpath="//input[@id='firstname']")
	public WebElement FirstName;
	
	@FindBy(xpath="//button[@type='submit' and @name='submitIdentity']")
	public WebElement Save;
	
	@FindBy(xpath="//input[@id='firstname']//preceding::div[1]//following::div[1]")
	public WebElement ValidFirstName;
	
	@FindBy(xpath="//*[@id='old_passwd']")
	public WebElement CurrentPassword;
	
	@FindBy(xpath="//*[@id='passwd']")
	public WebElement NewPassword;
	
	@FindBy(xpath="//*[@id='confirmation']")
	public WebElement ConfNewPassword;
	
	@FindBy(xpath="//input[@id='old_passwd']//preceding::div[1]//following::div[1]")
	public WebElement ValidCurrentPwd;
	
	@FindBy(xpath="//input[@id='passwd']//preceding::div[1]//following::div[1]")
	public WebElement ValidNewPwd;
	
	@FindBy(xpath="//input[@id='confirmation']//preceding::div[1]//following::div[1]")
	public WebElement ValidConfPwd;
	
	@FindBy(xpath="//*[@id='center_column']/div/p")
	public WebElement Successmsg;
	
	@FindBy(xpath="//*[@id='center_column']/div/div/ol/li")
	public WebElement ErrorMsg;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/a")
	public WebElement BacktoAcc;
	
	
	public void ClickPersonalInfo() {
		try {
			wait.until(ExpectedConditions.visibilityOf(PersonalInformation)).click();
			System.out.println("Clicked on PersonalInformation successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on PersonalInformation successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void updateFirstName(String UpdateName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(FirstName)).clear();
			FirstName.sendKeys(UpdateName);
			FirstName.sendKeys(Keys.TAB);
			if(wait.until(ExpectedConditions.visibilityOf(ValidFirstName)).getAttribute("class").contains("ok")) {
			System.out.println("Updated First name as "+FirstName.getText()+" successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Updated First name as "+FirstName.getText()+" successfully");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Invalid First name Entered "+UpdateName);
				Assert.fail("Invalid First name Entered "+UpdateName);
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void UpdatePassword() throws IOException {
		String Currentpwd = getProperty("Password");
		String Newpwd = getProperty("NewPassword");
		try {
			wait.until(ExpectedConditions.visibilityOf(CurrentPassword)).sendKeys(Currentpwd);
			CurrentPassword.sendKeys(Keys.TAB);
			if(wait.until(ExpectedConditions.visibilityOf(ValidCurrentPwd)).getAttribute("class").contains("ok")) {
				System.out.println("Entered Current password successfully");
				ExtentReportManager.test.log(LogStatus.PASS, "Entered Current password successfully");
				} else {
					ExtentReportManager.test.log(LogStatus.FAIL, "Invalid Current Password");
					Assert.fail("Invalid Current Password");
				}
			
			wait.until(ExpectedConditions.visibilityOf(NewPassword)).sendKeys(Newpwd);
			NewPassword.sendKeys(Keys.TAB);
			if(wait.until(ExpectedConditions.visibilityOf(ValidNewPwd)).getAttribute("class").contains("ok")) {
				System.out.println("Entered Current password successfully");
				ExtentReportManager.test.log(LogStatus.PASS, "Entered New password successfully");
				} else {
					ExtentReportManager.test.log(LogStatus.FAIL, "Invalid new Password");
					Assert.fail("Invalid New Password");
				}
			
			wait.until(ExpectedConditions.visibilityOf(ConfNewPassword)).sendKeys(Newpwd);
			ConfNewPassword.sendKeys(Keys.TAB);
			if(wait.until(ExpectedConditions.visibilityOf(ValidConfPwd)).getAttribute("class").contains("ok")) {
				System.out.println("Entered Conf password successfully");
				ExtentReportManager.test.log(LogStatus.PASS, "Entered Conf password successfully");
				} else {
					ExtentReportManager.test.log(LogStatus.FAIL, "Invalid Conf Password");
					Assert.fail("Invalid Conf Password");
				}
			
			System.out.println("Updated password successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Updated password successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickSave() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Save)).click();
			System.out.println("Clicked on Save button successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Save button successfully");
			
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ValidateSuccessMsg(String Expectedmsg) {
		try {
			String successMsg = wait.until(ExpectedConditions.visibilityOf(Successmsg)).getText();
			System.out.println("Success Messaage Displayed as "+successMsg);
			if(successMsg.equalsIgnoreCase(Expectedmsg)) {
			ExtentReportManager.test.log(LogStatus.PASS, "Success Message displayed as "+successMsg);
			} else {
			ExtentReportManager.test.log(LogStatus.FAIL, "Personal Details update is not successful");
			Assert.fail("Personal Details update is not successful");
			}
		} catch (Exception e) {
			if(ErrorMsg.isDisplayed()) {
				ExtentReportManager.test.log(LogStatus.FAIL, "Personal Information update is not successful due to error "+ErrorMsg.getText());
				Assert.fail("Personal Information update is not successful due to error "+ErrorMsg.getText());
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
				Assert.fail(e.getMessage());
			}
		}
	}
	
	public void VerifyUpdate(String UpdatedName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(BacktoAcc)).click();
			wait.until(ExpectedConditions.visibilityOf(PersonalInformation)).click();
			if(wait.until(ExpectedConditions.visibilityOf(FirstName)).getAttribute("value").equalsIgnoreCase(UpdatedName)) {
				System.out.println("First name updated as "+FirstName.getAttribute("value"));
				ExtentReportManager.test.log(LogStatus.PASS, "First name updated as "+FirstName.getAttribute("value"));
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "First name not updated as expected "+FirstName.getAttribute("value"));
				Assert.fail("First name not updated as expected "+FirstName.getAttribute("value"));
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
}
