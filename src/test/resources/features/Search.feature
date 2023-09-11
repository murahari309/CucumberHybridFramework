Feature: Search functionality


Scenario: user searches for a valid product
Given user open the application 
When user enters valid product "HP" into searchbox field
And user clicks on searchbox button 
Then user should get valid product displayed in search results

Scenario: user searches for a invalid product
Given user open the application
When user enters invalid product "HONDA" into searchbox field
And user clicks on searchbox button
Then user should get a message about no product matching

Scenario: user searches without any product
Given user open the application 
When user dont enter any product name in the searchbox field
And user clicks on searchbox button
Then user should get a message about no product matching





