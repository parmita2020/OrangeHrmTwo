@smartTest 
Feature: Validate login function in Orange HRM 

Scenario: User not able to login with valid credential 
	Given user not open web browser and navigate to Facebook login screen 
	Then user not Navigate to Page and verify the Page Title is "Facebook" 
	And user enter a invalid username and password 
	And user click the log in button 
	Then user not able to Navigate to Page and verify the Page Title is "Facebook" 
	When user click on log out button for Facebook 
	Then user Navigate and verify the Page Title is "Facebook" 