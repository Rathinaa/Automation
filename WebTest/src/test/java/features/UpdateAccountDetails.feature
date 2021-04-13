#Author: Rathinaa Deepak
#Created Date: 4-12-2021

Feature: Update Personal Information (First Name) in My Account

Scenario Outline: Verify if user is able to update Personal Information (First Name) in My Account
Given The user launches the URL
Then The Signin Page is displayed
When User Clicks on Sign in
Then The Authentication Page is displayed
And User Enters the Email and Password
And Clicks on the Sign in Button
Then the User is logged in as "<User>" Successfully
When User Clicks on Customer Account
And User Clicks on Personal Information Button
And User Updates the "<UpdateFirstName>" in the Personal Information
And User Updates the Password
When User Clicks on Save Button
Then The Message "Your personal information has been successfully updated." is displayed
Then the First name is updated as "<UpdateFirstName>"

Examples:
|User          |UpdateFirstName|
|Dravish Deepak|Dravish       |
 	 