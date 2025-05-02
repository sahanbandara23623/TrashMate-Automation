Feature: Payment for Waste Collection

  Background:
    Given I have opened the system
    And I wait few seconds
    And I wait few seconds
    And I click on "Login_Button"
    And I wait few seconds
    And I click on "Email"
    And I type "beesara.b@parallaxtec.com" to the "Email"
    And I wait few seconds
    And I click on "Password"
    And I wait few seconds
    And I type "beesara" to the "Password"
    And I wait few seconds
    And I click on "Login_Submit"
    And I wait few seconds
    And I wait few seconds

  Scenario:Make Valid Payment & Enter Payment Details
    And I click on "RWC_Button"
    And I wait few seconds
    And I click on "Food_waste_Weight"
    And I type "5" to the "Food_waste_Weight"
    And I wait few seconds
    And I click on "Proceed_to_Payment"
    And I wait few seconds
    And I wait few seconds
    And I click on "CardHolder_Name"
    And I generate a random name to the "CardHolder_Name"
    And I wait few seconds
    And I click on "Billing_Address"
    When I type a random address into the field "Billing_Address"
    And I wait few seconds
    And I click on "Email_Payment"
    And I generate a random email address to the "Email_Payment"
    And I wait few seconds
    And I click on "Phone_Number"
    And I generate a random mobile number to the "Phone_Number"
    And I wait few seconds
    When I enter "42424242424242420526135" into the "Card_Number" field
    And I wait few seconds
    When I just type "70620"
    And I wait few seconds
    And I click on "PayButton"
    And I wait few seconds
    And I wait few seconds
    And I wait few seconds
    And I wait few seconds

  Scenario:Make Payment & Invalid Card Details
    And I click on "RWC_Button"
    And I wait few seconds
    And I click on "Food_waste_Weight"
    And I type "5" to the "Food_waste_Weight"
    And I wait few seconds
    And I click on "Proceed_to_Payment"
    And I wait few seconds
    And I wait few seconds
    And I click on "CardHolder_Name"
    And I generate a random name to the "CardHolder_Name"
    And I wait few seconds
    And I click on "Billing_Address"
    When I type a random address into the field "Billing_Address"
    And I wait few seconds
    And I click on "Email_Payment"
    And I generate a random email address to the "Email_Payment"
    And I wait few seconds
    And I click on "Phone_Number"
    And I generate a random mobile number to the "Phone_Number"
    And I wait few seconds
    When I enter "00000000000000000526135" into the "Card_Number" field
    And I wait few seconds
    When I just type "70620"
    And I wait few seconds
    And I click on "PayButton"
    And I wait few seconds
    And I wait few seconds
    And I wait few seconds








