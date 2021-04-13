package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.ReusableLibrary;
import pageFactory.OrderTshirt;
import pageFactory.UpdatePersonalDetails;
import utilities.Drivermanager;
import utilities.ExtentReportManager;

public class StepDefinition_AutomationPractice {
	
	Drivermanager drivermanager = new Drivermanager();
	WebDriver driver = drivermanager.getDriver();
	ReusableLibrary reusablelibrary = new ReusableLibrary();
	OrderTshirt ordertshirt = new OrderTshirt(driver);
	UpdatePersonalDetails update = new UpdatePersonalDetails(driver);
	ExtentReportManager extentreport = new ExtentReportManager();

	@Given("^The user launches the URL$")
	public void the_user_launches_the_URL() throws Throwable {
		
		try {
			String ApplicationURL = reusablelibrary.getProperty("URL");
			driver.get(ApplicationURL);
			driver.manage().window().maximize();
			ExtentReportManager.test.log(LogStatus.PASS, "URL Launched successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The Signin Page is displayed$")
	public void the_Signin_Page_is_displayed() throws Throwable {
		ordertshirt.VerifySignInPage();
	}
	
	@When("^User Clicks on Sign in$")
	public void user_Clicks_on_Sign_in() throws Throwable {
		ordertshirt.ClickSigninButton();
	}
	
	@Then("^The Authentication Page is displayed$")
	public void the_Authentication_Page_is_displayed() throws Throwable {
		ordertshirt.VerifyAuthpage();
	}
	
	@Then("^User Enters the Email and Password$")
	public void user_Enters_the_Email_and_Password() throws Throwable {
		ordertshirt.EnterEmailandPwd();
	}
	
	@Then("^Clicks on the Sign in Button$")
	public void clicks_on_the_Sign_in_Button() throws Throwable {
		ordertshirt.Login();
	}

	@Then("^the User is logged in as \"([^\"]*)\" Successfully$")
	public void the_User_is_logged_in_as_Successfully(String arg1) throws Throwable {
		ordertshirt.CheckLogin(arg1);
	}

	@When("^User Clicks on the TShirt Menu$")
	public void user_Clicks_on_the_TShirt_Menu() throws Throwable {
	    ordertshirt.ClickTshirtMenu();
	}
	
	@When("^Selects \"([^\"]*)\" from the list$")
	public void selects_from_the_list(String productname) throws Throwable {
	    ordertshirt.SelectProduct(productname);
	}
	
	@Then("^The User is navigated to the Tshirt Details page of the \"([^\"]*)\"$")
	public void the_User_is_navigated_to_the_Tshirt_Details_page_of_the(String productname) throws Throwable {
	    ordertshirt.CheckOrderNavigation(productname);
	}
	
	@Then("^The User selects the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_User_selects_the_and(String quantity, String size, String colour) throws Throwable {
		ordertshirt.SelectQuantity(quantity);
		ordertshirt.SelectSize(size);
		ordertshirt.SelectColour(colour);
	}

	@Then("^Clicks on Add to Cart$")
	public void clicks_on_Add_to_Cart() throws Throwable {
	   ordertshirt.AddtoCart();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void message_is_displayed(String arg1) throws Throwable {
	    ordertshirt.Checkproductadd();
	}
	
	@Then("^User click on Proceed to Checkout in the order page$")
	public void user_click_on_Proceed_to_Checkout_in_the_order_page() throws Throwable {
		ordertshirt.ClickProceed();
	}
	
	@Then("^The Order Sumary Page is displayed$")
	public void the_Order_Sumary_Page_is_displayed() throws Throwable {
	    ordertshirt.VerifyOrderSummaryPage();
	}
	
	@Then("^The \"([^\"]*)\", Availability, Unit Price, Shipping, \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" Total Price is displayed as expected$")
	public void the_Availability_Unit_Price_Shipping_Total_Price_is_displayed_as_expected(String prodname, String quantity, String size, String colour) throws Throwable {
		ordertshirt.VerifyOrderSummary(prodname, quantity, size, colour);
	}

	@When("^User Clicks in the proceed to check out button in the order Summary page$")
	public void user_Clicks_in_the_proceed_to_check_out_button_in_the_order_Summary_page() throws Throwable {
		ordertshirt.ProceedtoCheckOut_OrderSumary();
	}
	
	@Then("^User is navigated to the address Tab and Selects the delivery Address as \"([^\"]*)\"$")
	public void user_is_navigated_to_the_address_Tab_and_Selects_the_delivery_Address_as(String Addressoption) throws Throwable {
		ordertshirt.ChooseDeliveryAddress(Addressoption);
	}
	
	@Then("^User click on Proceed to Checkout in the Address Tab$")
	public void user_click_on_Proceed_to_Checkout_in_the_Address_Tab() throws Throwable {
		ordertshirt.ProceedtoCheckOut_Address();
	}
	
	@Then("^the user is navigated to Shipping Tab and \"([^\"]*)\" message is displayed$")
	public void the_user_is_navigated_to_Shipping_Tab_and_message_is_displayed(String msg) throws Throwable {
		ordertshirt.VerifyShipping(msg);
	}
	
	@When("^User Clicks in \"([^\"]*)\" Checkbox$")
	public void user_Clicks_in_Checkbox(String arg1) throws Throwable {
		ordertshirt.IAgree_Shipping();
	}
	
	@When("^User click on Proceed to Checkout in the Shipping Tab$")
	public void user_click_on_Proceed_to_Checkout_in_the_Shipping_Tab() throws Throwable {
		ordertshirt.ProceedtoCheckOut_Shipping();
	}
	
	@Then("^the User is naviagated to the Payment Tab$")
	public void the_User_is_naviagated_to_the_Payment_Tab() throws Throwable {
		ordertshirt.VerifyPaymentPage();
	}
	
	@Then("^User Selects \"([^\"]*)\" Option$")
	public void user_Selects_Option(String paymentmethod) throws Throwable {
		ordertshirt.SelectPayment(paymentmethod);
	}
	
	@Then("^USer Click on \"([^\"]*)\" Button$")
	public void user_Click_on_Button(String arg1) throws Throwable {
		ordertshirt.ConfirmOrder();
	}
	
	@Then("^\"([^\"]*)\" is displayed$")
	public void is_displayed(String ordrmsg) throws Throwable {
		ordertshirt.OrderComplete(ordrmsg);
	}
	
	@When("^User Clicks on Customer Account$")
	public void user_Clicks_on_Customer_Account() throws Throwable {
		ordertshirt.ClickCustAccount();
	}
	
	@Then("^User Clicks on Order history and Details$")
	public void user_Clicks_on_Order_history_and_Details() throws Throwable {
		ordertshirt.ClickOrderHistory();
	}
	
	@Then("^the Order placed is displayed in the order details as expected$")
	public void the_Order_placed_is_displayed_in_the_order_details_as_expected() throws Throwable {
	    ordertshirt.VerifyOrderHistory();
	}
	
	@When("^User Clicks on Personal Information Button$")
	public void user_Clicks_on_Personal_Information_Button() throws Throwable {
		update.ClickPersonalInfo();
	}

	@When("^User Updates the \"([^\"]*)\" in the Personal Information$")
	public void user_Updates_the_in_the_Personal_Information(String firstname) throws Throwable {
		update.updateFirstName(firstname);
	}

	@When("^User Updates the Password$")
	public void user_Updates_the_Password() throws Throwable {
		update.UpdatePassword();
	}

	@When("^User Clicks on Save Button$")
	public void user_Clicks_on_Save_Button() throws Throwable {
		update.ClickSave();
	}

	@Then("^the First name is updated as \"([^\"]*)\"$")
	public void the_First_name_is_updated_as(String firstname) throws Throwable {
		update.VerifyUpdate(firstname);
	}
	
	@Then("^The Message \"([^\"]*)\" is displayed$")
	public void the_Message_is_displayed(String msg) throws Throwable {
		update.ValidateSuccessMsg(msg);
	}
}
