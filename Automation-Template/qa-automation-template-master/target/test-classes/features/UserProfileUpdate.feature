Feature: User Profile Update Feature

  Background:
    Given I have opened the system

    And I wait few seconds
    And I click on "Login_Button"
    And I click on "Email"
    And I type "test@gmail.com" to the "Email"
    And I click on "Password"
    And I type "1234" to the "Password"
    And I click on "Login_Submit"
    And I wait few seconds

  Scenario: Navigate to the Profile Tab
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds

  Scenario: Update the User Name
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds
    And I click on "User_Name"
    And I wait few seconds
    When I clear text  "User_Name"
    And I wait few seconds
    And I generate a random UserName to the "User_Name"
    And I wait few seconds
    And I click on "User_Details_Update_Button"
    And I wait few seconds

  Scenario: Update The Email
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds
    And I click on "User_Email"
    And I wait few seconds
    When I clear text  "User_Email"
    And I wait few seconds
    And I generate a random email address to the "User_Email"
    And I wait few seconds
    And I click on "User_Details_Update_Button"
    And I wait few seconds

  Scenario: Update The Phone Number
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds
    And I click on "User_PhoneNumber"
    And I wait few seconds
    When I clear text  "User_PhoneNumber"
    And I wait few seconds
    And I generate a random mobile number to the "User_PhoneNumber"
    And I wait few seconds
    And I click on "User_Details_Update_Button"
    And I wait few seconds

  Scenario: Update all details
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds
    And I click on "User_Name"
    And I wait few seconds
    When I clear text  "User_Name"
    And I wait few seconds
    And I generate a random UserName to the "User_Name"
    And I wait few seconds
    And I click on "User_Email"
    And I wait few seconds
    When I clear text  "User_Email"
    And I wait few seconds
    And I generate a random email address to the "User_Email"
    And I wait few seconds
    And I click on "User_PhoneNumber"
    And I wait few seconds
    When I clear text  "User_PhoneNumber"
    And I wait few seconds
    And I generate a random mobile number to the "User_PhoneNumber"
    And I wait few seconds
    And I click on "User_Details_Update_Button"
    And I wait few seconds


  Scenario: Invalid Email Check
    And I wait few seconds
    And I click on "Profile_Tab"
    And I wait few seconds
    And I click on "User_Email"
    And I wait few seconds
    When I clear text  "User_Email"
    And I wait few seconds
    And I type "test#gmail.com" to the "Email"
    And I wait few seconds
    And I click on "User_Details_Update_Button"
    And I wait few seconds


