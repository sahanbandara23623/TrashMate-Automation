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
    And I click on "Request_Waste_Collection_Tab"
    And I wait few seconds

  Scenario: Enter Weights for Food Waste
    And I wait few seconds
    And I click on "Weight_Food"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds

  Scenario: Enter Weights for Cardboard Waste
    And I wait few seconds
    And I click on "Weight_CardBoard"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds

  Scenario: Enter Weights for Polythene Waste
    And I wait few seconds
    And I click on "Weight_Polythene"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds


  Scenario: Enter Weights for Food Waste , Cardboard Waste and Polythene Waste
    And I wait few seconds
    And I click on "Weight_Food"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Weight_CardBoard"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Weight_Polythene"
    And I wait few seconds
    When I press the up arrow key
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds

  Scenario: Enter Random Weights for Polythene Waste
    And I wait few seconds
    And I click on "Weight_Polythene"
    And I wait few seconds
    When I press the up arrow key a random number of times
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds

  Scenario: Enter Random Weights for Cardboard Waste
    And I wait few seconds
    And I click on "Weight_CardBoard"
    And I wait few seconds
    When I press the up arrow key a random number of times
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds

  Scenario: Enter Random Weights for Food Waste
    And I wait few seconds
    And I click on "Weight_Food"
    And I wait few seconds
    When I press the up arrow key a random number of times
    And I wait few seconds
    And I click on "Proceed_Payment_Button"
    And I wait few seconds