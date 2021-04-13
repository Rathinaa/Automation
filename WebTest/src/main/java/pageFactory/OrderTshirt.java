package pageFactory;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utilities.Drivermanager;
import utilities.ExtentReportManager;

public class OrderTshirt extends Drivermanager {
	
	Actions action = new Actions(driver);
	public static WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	ExtentReportManager extentreport = new ExtentReportManager();
	public String OrderID  = "";
	
	public OrderTshirt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	public WebElement HomeSigninButton;
	
	@FindBy(xpath="//h1[@class='page-heading' and text()='Authentication']")
	public WebElement AuthenticationText;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement Password;
	
	@FindBy(xpath="//div[@class='form-group form-ok']")
	public WebElement Emailvalid;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	public WebElement PWDAuthFail;
	
	@FindBy(xpath="//*[@id='SubmitLogin']/span/i")
	public WebElement LoginSigninButton;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
	public WebElement TShirtMenu;
	
	@FindBy(xpath="//a[@title='View my customer account']/span")
	public WebElement AccountName;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	public List <WebElement> ProductList;
	
	@FindBy(xpath="//a[@class='product-name' and @itemprop='url']")
	public WebElement ProductName;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	public WebElement ViewCart;
	
	@FindBy(xpath="//a[@title='View my shopping cart']/span[@class='ajax_cart_quantity']")
	public WebElement CartQuantity;
	
	@FindBy(xpath="//button[@type='submit']//span[text()='Add to cart']")
	public WebElement AddtoCart;
	
	@FindBy(xpath="//span[@class='navigation-pipe']")
	public List <WebElement> orderStages;
	
	@FindBy(xpath="//*[@id='center_column']/div/div/div[3]/h1")
	public WebElement TshirtNameDetails;
	
	@FindBy(xpath="//*[@id='quantity_wanted']")
	public WebElement Quantity;
	
	@FindBy(xpath="//*[@id='group_1']")
	public WebElement Size;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li/a")
	public List <WebElement> Colour;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li[@class='selected']/a")
	public WebElement SelectedColour;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	public WebElement Proceed;
	
	@FindBy(xpath="//*[@id='cart_title']")
	public WebElement shoppingcartSumary;
	
	@FindBy(xpath="//input[@class='cart_quantity_input form-control grey']")
	public WebElement SummaryProdQuantity;
	
	@FindBy(xpath="//table[@id='cart_summary']//tr[1]/td[2]/small[2]/a")
	public WebElement SummaryColourandSize;
	
	@FindBy(xpath="//span[@class='label label-success']")
	public WebElement InStock;
	
	@FindBy(xpath="//*[@id='total_shipping']")
	public WebElement Shippingcharge;
	
	@FindBy(xpath="//*[@id='total_product']")
	public WebElement UnitPrice;
	
	@FindBy(xpath="//*[@id='total_price']")
	public WebElement TotalAmount;
	
	@FindBy(xpath="//*[@id='center_column']/p/a[@title='Proceed to checkout']")
	public WebElement ProceedfromOrderSummary;
	
	@FindBy(xpath="//*[@id='center_column']/form/p/button")
	public WebElement ProceedfromAddress;
	
	@FindBy(xpath="//*[@id='form']/p/button")
	public WebElement ProceedfromShipping;
	
	@FindBy(xpath="//*[@id='uniform-cgv']/span")
	public WebElement IAgreeShipping;
	
	@FindBy(xpath="//a[@class='bankwire']")
	public WebElement BankwirePayment;
	
	@FindBy(xpath="//a[@class='cheque']")
	public WebElement CheckPayment;
		
	@FindBy(xpath="//*[@id='cart_navigation']/button")
	public WebElement IConfirmButton;

	@FindBy(xpath="//*[@id='id_address_delivery']")
	public WebElement ChooseDeliveryAddress;
	
	@FindBy(xpath="//*[@id='form']/div/div[2]/div[1]/div/div/table/tbody/tr/td[3]")
	public WebElement Shippingmsg;
	
	@FindBy(xpath="//*[@id='HOOK_PAYMENT']")
	public WebElement PaymentPage;
	
	@FindBy(xpath="//*[@id='center_column']/div/p/strong")
	public WebElement OrderComplete;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	public WebElement CustomerAccount;
	
	@FindBy(xpath="//a[@title='Orders']")
	public WebElement OrderHistory;
	
	@FindBy(xpath="//*[@id='center_column']/div")
	public WebElement Order;

	@FindBy(xpath="//table[@id='order-list']/tbody/tr")
	public List <WebElement> OrderList;
	
	
		
	public void VerifySignInPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(HomeSigninButton)).isDisplayed();
			System.out.println("Sign in Button dislayed successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Sign in Button dislayed successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickSigninButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(HomeSigninButton)).click();
			System.out.println("Clicked on Sign in successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Sign in successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyAuthpage() {
		try {
			if(AuthenticationText.getText().equalsIgnoreCase("Authentication")) {
			System.out.println(AuthenticationText.getText()+" Page displayed successfully");
			ExtentReportManager.test.log(LogStatus.PASS, AuthenticationText.getText()+" Page displayed successfully");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Authentication page not displayed");
				Assert.fail("Authentication page not displayed");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void EnterEmailandPwd() throws Exception {
		String email = getProperty("Email");
		String password = getProperty("Password");
		try {
			if(email.contains("@")) {
				System.out.println("user has provided a valid email ID");
				ExtentReportManager.test.log(LogStatus.INFO, "user has provided a valid email ID");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Email ID is Invalid");
				Assert.fail("Email ID is Invalidd");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(email);
			System.out.println("Entered email ID as successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Entered email ID successfully");
			Email.sendKeys(Keys.TAB);
				if(wait.until(ExpectedConditions.visibilityOf(Emailvalid)).isDisplayed()) {
					System.out.println("user has provided a valid email ID");
					ExtentReportManager.test.log(LogStatus.INFO, "user has provided a valid email ID");
				} else {
					ExtentReportManager.test.log(LogStatus.FAIL, "Email ID is Invalid");
					Assert.fail("Email ID is Invalid");
				}
				
				wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(password);
				System.out.println("Entered Password successfully");
				ExtentReportManager.test.log(LogStatus.PASS, "Entered Password successfully");	
		
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	public void Login() {
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginSigninButton)).click();
			System.out.println("Clicked on Sign in after entering email and password");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Sign in after entering email and password");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickTshirtMenu() {
		try {
			wait.until(ExpectedConditions.visibilityOf(TShirtMenu)).click();
			System.out.println("Clicked on Tshirt menu Successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Tshirt menu Successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void CheckLogin(String Accountname) {
		
		try {
			if(wait.until(ExpectedConditions.visibilityOf(AccountName)).isDisplayed()) {
				System.out.println("Account name in UI is "+AccountName.getText());
				if(AccountName.getText().equalsIgnoreCase(Accountname)) {
					ExtentReportManager.test.log(LogStatus.PASS, "Login Successful for "+AccountName.getText());
				} else {
					ExtentReportManager.test.log(LogStatus.FAIL, "Account name in the input "+Accountname+" is different from the account name in UI "+AccountName.getText());
					Assert.fail("Account name in the input "+Accountname+" is different from the account name in UI "+AccountName.getText());
				}
			}
		} catch(Exception e) {
			if(PWDAuthFail.isDisplayed()) {
				ExtentReportManager.test.log(LogStatus.FAIL, "Login Failure due "+PWDAuthFail.getText());
				Assert.fail("Login Failure due "+PWDAuthFail.getText());
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
				Assert.fail(e.getMessage());
			}
		}
	}
	
	public void SelectProduct(String productName) throws Exception {
		int i=0;
		WebElement productname = null;
		int productlistsie = wait.until(ExpectedConditions.visibilityOfAllElements(ProductList)).size();
		System.out.println(productlistsie);
			try {
				int productlistsize = wait.until(ExpectedConditions.visibilityOfAllElements(ProductList)).size();
				System.out.println(productlistsize);
				for(i=1; i<=productlistsize;i++) {
						productname = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='product_list grid row']/li["+i+"]//following::a[@class='product-name' and @itemprop='url']"))));
						if(productname.getAttribute("title").equalsIgnoreCase(productName)) {
							System.out.println("Product name is "+productname.getAttribute("title"));
							ExtentReportManager.test.log(LogStatus.PASS, "Product name is "+productname.getAttribute("title"));
							action.moveToElement(productname).click().build().perform();
							System.out.println("clicked on mouseover");
							break;
						}
				}
				
				if(i>productlistsize&&!productname.getAttribute("title").equalsIgnoreCase(productName)){
					ExtentReportManager.test.log(LogStatus.FAIL, "Unable to select Product with name "+productName);
					Assert.fail("Unable to select Product with name "+productName);
				}
			} catch (Exception e) {
				ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
				Assert.fail(e.getMessage());
			}
	}
	
	public void AddtoCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(AddtoCart)).click();
			System.out.println("Clicked on add to cart successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on add to cart successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public void CheckOrderNavigation(String Productname) {
		try {
			System.out.println("T name is "+TshirtNameDetails.getText());
			if(TshirtNameDetails.getText().equalsIgnoreCase(Productname)) {
				System.out.println("User is navigated to order Details Page of "+TshirtNameDetails.getText());
				ExtentReportManager.test.log(LogStatus.PASS, "User is navigated to order Details Page of "+TshirtNameDetails.getText());
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "User not naviagated to Order Details page");
				Assert.fail("User not naviagated to Order Details page");
			}
			
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void SelectQuantity(String InputQuantity) {
		try {
			wait.until(ExpectedConditions.visibilityOf(Quantity)).clear();
			Quantity.sendKeys(InputQuantity);
			System.out.println("Quantity is selected as "+Quantity.getText());
			ExtentReportManager.test.log(LogStatus.PASS, "Quantity is selected as "+Quantity.getText());
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void SelectSize(String Inputsize) {
		try {
			Select sel = new Select(Size);
			sel.selectByVisibleText(Inputsize);		
			System.out.println("Size is selected as "+Inputsize);
			ExtentReportManager.test.log(LogStatus.PASS, "Size is selected as "+Inputsize);
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void SelectColour(String InputColour) throws Exception {
		
		try {
			for(int i=0; i<Colour.size(); i++) {
				System.out.println("Colours are "+Colour.get(i).getAttribute("title"));
				if(Colour.get(i).getAttribute("title").equalsIgnoreCase(InputColour)){
					Colour.get(i).click();
					break;
				}
				ExtentReportManager.test.log(LogStatus.PASS, "Colour is selected as "+InputColour);
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void Checkproductadd() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Proceed)).isDisplayed();
			System.out.println("Product added to cart successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Product added to cart successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickProceed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Proceed)).click();
			System.out.println("Clicked on Proceed to check out button successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Proceed to check out button successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyOrderSummaryPage() {
		try {
			System.out.println("Text is "+shoppingcartSumary.getText());
			if(shoppingcartSumary.getText().contains("SHOPPING-CART SUMMARY")) {
				System.out.println(shoppingcartSumary.getText()+" page dispayed as expected");
				ExtentReportManager.test.log(LogStatus.PASS, shoppingcartSumary.getText()+" page dispayed as expected");
			} else {
			ExtentReportManager.test.log(LogStatus.FAIL, "Unable to naviagate to Order Summary page");
			Assert.fail("Unable to naviagate to Order Summary page");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyOrderSummary(String inputprodname, String inputquantity, String inputsize, String inputcolour) throws Exception {
		
		try {
			WebElement SummaryProdName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='product-name']/a[text()='"+inputprodname+"']"))));
			String sumprodname = SummaryProdName.getText();
			if(sumprodname.equalsIgnoreCase(inputprodname)) {
			ExtentReportManager.test.log(LogStatus.PASS, SummaryProdName.getText()+" displayed as expected");
			} else {
			ExtentReportManager.test.log(LogStatus.FAIL, "Product name displayed is "+sumprodname+" and not as expected ");
			Assert.fail("Product name not displayed is "+sumprodname+" and not as expected");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}	
		
		try {
			String sumprodquantity = wait.until(ExpectedConditions.visibilityOf(SummaryProdQuantity)).getAttribute("value");
			if(sumprodquantity.equalsIgnoreCase(inputquantity)){
				System.out.println(sumprodquantity+" displayed as expected");
				ExtentReportManager.test.log(LogStatus.PASS, sumprodquantity+" displayed as expected");
			}else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Product Quanity displayed is "+sumprodquantity+" and not as expected");
				Assert.fail("Product Quanity displayed is "+sumprodquantity+" and not as expected");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		//check prod colour and size
		try {
			String sizeandcolour = SummaryColourandSize.getText();
			System.out.println("Size and colour is "+sizeandcolour);
			String text[] = sizeandcolour.split("Color : ");
			String text2 [] = text[1].split(",");
			String prodcolor = text2[0];
			System.out.println("Colour is "+prodcolor);
			String text3[]=text2[1].split(" Size : ");
			String prodSize = text3[1];
			System.out.println("Size is "+prodSize);
			
			if(inputcolour.equalsIgnoreCase(prodcolor)) {
				System.out.println("Colour seleted for the product is displayed as "+prodcolor+" as expected");
				ExtentReportManager.test.log(LogStatus.PASS, "Colour seleted for the product is displayed as "+prodcolor+" as expected");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Product Colour displayed is "+prodcolor+" and not as expected");
				Assert.fail("Product Colour displayed is "+prodcolor+" and not as expected");
			}
			
			if(inputsize.equalsIgnoreCase(prodSize)) {
				System.out.println("Size seleted for the product is displayed as "+prodSize+" as expected");
				ExtentReportManager.test.log(LogStatus.PASS, "Size seleted for the product is displayed as "+prodSize+" as expected");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Product Size displayed is "+prodSize+" and not as expected");
				Assert.fail("Product Size displayed is "+prodSize+" and not as expected");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		try {
			String instock = wait.until(ExpectedConditions.visibilityOf(InStock)).getText();
			System.out.println(instock+" displayed as expected");
			ExtentReportManager.test.log(LogStatus.PASS, instock+" displayed as expected");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		try {
			String shipcharge = wait.until(ExpectedConditions.visibilityOf(Shippingcharge)).getText();
			System.out.println(shipcharge+" displayed as expected");
			ExtentReportManager.test.log(LogStatus.PASS, shipcharge+" displayed as expected");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		try {
			String unitprice = wait.until(ExpectedConditions.visibilityOf(UnitPrice)).getText();
			System.out.println(unitprice+" displayed as expected");
			ExtentReportManager.test.log(LogStatus.PASS, unitprice+" displayed as expected");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		try {
			String totalamt = wait.until(ExpectedConditions.visibilityOf(TotalAmount)).getText();
			System.out.println(totalamt+" displayed as expected");
			ExtentReportManager.test.log(LogStatus.PASS, totalamt+" displayed as expected");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}

	}
	
	public void ProceedtoCheckOut_OrderSumary() {
		try {
			wait.until(ExpectedConditions.visibilityOf(ProceedfromOrderSummary)).click();
			System.out.println("Clicked on proceed to Checkout button in Order Summary");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on proceed to Checkout button in Order Summary");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ProceedtoCheckOut_Address() {
		try {
			wait.until(ExpectedConditions.visibilityOf(ProceedfromAddress)).click();
			System.out.println("Clicked on proceed to Checkout button in Address Page");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on proceed to Checkout button in Address Page");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ProceedtoCheckOut_Shipping() {
		try {
			wait.until(ExpectedConditions.visibilityOf(ProceedfromShipping)).click();
			System.out.println("Clicked on proceed to Checkout button in Shipping Page");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on proceed to Checkout button in Shipping Page");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void IAgree_Shipping() {
		try {
			wait.until(ExpectedConditions.visibilityOf(IAgreeShipping)).click();
			System.out.println("Clicked on I Agree in Shipping Page");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on I Agree in Shipping Page");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void SelectPayment(String PaymentMethod) {
		try {
			if(PaymentMethod.equalsIgnoreCase("Pay by wire")){
			wait.until(ExpectedConditions.visibilityOf(BankwirePayment)).click();
			System.out.println("Clicked on pay by bank wire Option");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on pay by bank wire Option");
			} else if (PaymentMethod.equalsIgnoreCase("pay by check")) {
				wait.until(ExpectedConditions.visibilityOf(CheckPayment)).click();
				System.out.println("Clicked on pay by Checque Option");
				ExtentReportManager.test.log(LogStatus.PASS, "Clicked on pay by Cheque Option");
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ConfirmOrder() {
		try {
			wait.until(ExpectedConditions.visibilityOf(IConfirmButton)).click();
			System.out.println("Clicked on I Confirm order Page");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on I Confirm order Page");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ChooseDeliveryAddress(String AddressOption) {
		try {
			Select sel = new Select(ChooseDeliveryAddress);
			sel.selectByVisibleText(AddressOption);
			System.out.println("Delivery Address selected successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Delivery Address selected successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyShipping(String Expectedmsg) {
		try {
			String Shipmsg = wait.until(ExpectedConditions.visibilityOf(Shippingmsg)).getText();
			if(Shipmsg.equalsIgnoreCase(Expectedmsg)) {
			System.out.println("navigated to Shipping page and shipping message displayed successfuly as "+Shipmsg);
			ExtentReportManager.test.log(LogStatus.PASS, "navigated to Shipping page and shipping message displayed successfuly as "+Shipmsg);
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Shipping message is not displayed as expected "+Shipmsg);
				Assert.fail("Shipping message is not displayed as expected "+Shipmsg);
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyPaymentPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(PaymentPage)).isDisplayed();
			System.out.println("PaymentPage displayed successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "PaymentPage displayed successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void OrderComplete(String ordermsg) {
		try {
			String msg = wait.until(ExpectedConditions.visibilityOf(OrderComplete)).getText();
			if(msg.equalsIgnoreCase(ordermsg)) {
			System.out.println(msg+" message displayed successfully");
			ExtentReportManager.test.log(LogStatus.PASS, msg+" message displayed successfully");
			} else {
				ExtentReportManager.test.log(LogStatus.FAIL, "Order message not displayed as expected "+msg);
				Assert.fail("Order message not displayed as expected "+msg);
			}
			
			
			String OrderSummary = Order.getText();
			System.out.println("Order summary is "+OrderSummary);
			String [] split = OrderSummary.split("reference ");
			String firstSubString = split[0];
			String secondSubString = split[1];
			System.out.println("Splitted 1 "+firstSubString+" and "+secondSubString);
			OrderID = secondSubString.substring(0, 9);
			System.out.println("Order ID is "+OrderID);
			ExtentReportManager.test.log(LogStatus.INFO, " Order ID is "+OrderID);
			
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickCustAccount() {
		try {
			wait.until(ExpectedConditions.visibilityOf(CustomerAccount)).click();
			System.out.println("Clicked on customer account successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on customer account successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void ClickOrderHistory() {
		try {
			wait.until(ExpectedConditions.visibilityOf(OrderHistory)).click();
			System.out.println("Clicked on OrderHistory successfully");
			ExtentReportManager.test.log(LogStatus.PASS, "Clicked on Order History successfully");
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void VerifyOrderHistory() {
		try {
			int size = OrderList.size();
			System.out.println("Order list size is "+size);
			for(int i=1; i<=size; i++) {
				String orderid = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[1]/a")).getText();
				System.out.println(orderid);
				if(orderid.equalsIgnoreCase(OrderID)) {
					System.out.println("Order ID displayed in order History Successfully");
					ExtentReportManager.test.log(LogStatus.PASS, "Order ID displayed in order History Successfully");
					String price = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[3]")).getAttribute("data-value");
					System.out.println("Price isdisplayed successfully as "+price);
					ExtentReportManager.test.log(LogStatus.INFO, "Price isdisplayed successfully as "+price);
					String Backorder = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[5]/span")).getText();
					System.out.println("Order status is "+Backorder);
					ExtentReportManager.test.log(LogStatus.INFO, "Order status is "+Backorder);
				} else if(i>size) {
					ExtentReportManager.test.log(LogStatus.FAIL, "Unable to find the order ID");
					Assert.fail("Unable to find the order ID");
				}
			}
		} catch (Exception e) {
			ExtentReportManager.test.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

}
