Feature: Registration Functionality

Scenario: User create Account with mandotory fields
Given user navigates to RegisterAccount page
When user enters the details into below fields
|FirstName |vamika |
|LastName  |mudi|
|Telephone  |0987654321 |
|Password   |123411|
And user selects the privacy policy button 
And user clicks on continue button 
Then user account should get created successfully 


Scenario: User create Account with all fields
Given user navigates to RegisterAccount page
When user enters the details into below fields
|FirstName |jamika |
|LastName  |mudiraj|
|Telephone  |9876543210 |
|Password   |123489|
And user selects yes for newsletter
And user selects the privacy policy button 
And user clicks on continue button 
Then user account should get created successfully


Scenario: User create A duplicate Account
Given user navigates to RegisterAccount page
When user enters the details into below fieldsss
|FirstName |vamika |
|LastName  |mudiraj|
|E-Mail    |varun1234@gmail.com |
|Telephone  |1234567891 |
|Password   |1234|
And user selects yes for newsletter
And user selects the privacy policy button 
And user clicks on continue button 
Then user should get a proper warning about duplicate email

Scenario: user creates an account without filling anydetails
Given user navigates to RegisterAccount page
When user dont enter any details into fields
And user clicks on continue button
Then user should get a proper warning messages


