Feature: Garbage Collector Feature

  Background:
    Given I have opened the system
    And I wait few seconds
    And I click on "Login_Button"
    And I wait few seconds
    And I click on "Email"
    And I type "venura.test@gmail.com" to the "Email"
    And I wait few seconds
    And I click on "Password"
    And I wait few seconds
    And I type "1111" to the "Password"
    And I wait few seconds
    And I click on "Login_Submit"
    And I wait few seconds
    And I wait few seconds

  Scenario: Assign User Garbage Collect
    And I click on "Assigned_User_Button"
    And I wait few seconds
    And I click on "Collect_Garbage_Button"
    And I wait few seconds
    And I click on "Waste_Type_Selector"
    And I wait few seconds



