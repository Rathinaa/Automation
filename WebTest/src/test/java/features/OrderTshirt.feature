#Author: Rathinaa Deepak
#Created Date: 4-8-2021

Feature: Order T-Shirt and Verify in Order History

Scenario Outline: Verify if the user able to Order a T shirt from the Tshirt menu and verify the same from the Order History
Given The user launches the URL
Then The Signin Page is displayed
When User Clicks on Sign in
Then The Authentication Page is displayed
And User Enters the Email and Password
And Clicks on the Sign in Button
Then the User is logged in as "<User>" Successfully
When User Clicks on the TShirt Menu
And Selects "<Product>" from the list
Then The User is navigated to the Tshirt Details page of the "<Product>"
And The User selects the "<Quantity>", "<Size>" and "<Colour>"
And Clicks on Add to Cart
Then "Product successfully added to your shopping cart" message is displayed
And User click on Proceed to Checkout in the order page
Then The Order Sumary Page is displayed
And The "<Product>", Availability, Unit Price, Shipping, "<Quantity>", "<Size>", "<Colour>" Total Price is displayed as expected
When User Clicks in the proceed to check out button in the order Summary page
Then User is navigated to the address Tab and Selects the delivery Address as "My address"
And User click on Proceed to Checkout in the Address Tab
And the user is navigated to Shipping Tab and "My carrier Delivery next day!" message is displayed
When User Clicks in "I agree to the terms of service and will adhere to them unconditionally" Checkbox
And User click on Proceed to Checkout in the Shipping Tab
Then the User is naviagated to the Payment Tab
And User Selects "<PaymentOption>" Option
And USer Click on "I Confirm my Order" Button
Then "Your order on My Store is complete." is displayed
When User Clicks on Customer Account
Then User Clicks on Order history and Details
And the Order placed is displayed in the order details as expected

Examples:
|User          |Product                    |Quantity|Size|Colour|PaymentOption|
|Dravish Deepak|Faded Short Sleeve T-shirts|2       |M   |Blue  |Pay by wire  |