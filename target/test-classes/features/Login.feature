Feature: Login functionality

Scenario Outline: Login with valid credentials
Given user has navigates login page
When User entered valid Emailaddress <username> into the emailfield
And User entered valid Password <password> into the passwordfield
And user clicks on login button 
Then user should be able to successfully logged in
Examples:
|username              |password|
|varun1234@gmail.com   |1234|
|varun12345@gmail.com  |1234|
|varun123456@gmail.com |1234|

Scenario: Login with invalid credentials
Given user has navigates login page
When user entered invalid Emailaddress into the emailfield
And user entered invalid Password "98w76373" into the passwordfiled
And user clicks on login button
Then user should get a proper warning message about credentials missmatch

Scenario: Login with valid Email and inavalid password
Given user has navigates login page
When User entered valid Emailaddress "varun1234@gmail.com" into the emailfield
And user entered invalid password "97365" into passwordfield 
And user clicks on login button
Then user should get a proper warning message about credentials missmatch 

Scenario: Login with invalid Emailaddress and valid password
Given user has navigates login page
When user entered invalid Emailaddress into the emailfield
And User entered valid Password "1234" into the passwordfield
And user clicks on login button
Then user should get a proper warning message about credentials missmatch

Scenario: Login with without providing any credentials
Given user has navigates login page
When user dont enter emailaddress into the emailfield
And user dont enter password into the passwordfield
And user clicks on login button
Then user should get a proper warning message about credentials missmatch




