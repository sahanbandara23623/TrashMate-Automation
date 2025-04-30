Feature: Garbage Collector Feature

  Background:
    Given I have opened the system
    And I click on "Login_Button"
    And I wait few seconds
    And I click on "Email"
    And I type "venura.test@gmail.com" to the "Email"
    And I click on "Password"
    And I type "1111" to the "Password"
    And I click on "Login_Submit"
    And I wait few seconds

  Scenario: Assign User Garbage Collect Food Waste
    And I click on "Assigned_User_Button"
    And I wait few seconds
    And I click on "Collect_Garbage_Button"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Garbage_Submit"

  Scenario: Assign User Garbage Collect Cardboard
    And I click on "Assigned_User_Button"
    And I wait few seconds
    And I click on "Collect_Garbage_Button"
    And I wait few seconds
    And I click on "Waste_Type_Selector"
    And I wait few seconds
    When I press the down arrow key
    And I click on "Cardboard_Option"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Garbage_Submit"

  Scenario: Assign User Garbage Collect polythene
    And I click on "Assigned_User_Button"
    And I wait few seconds
    And I click on "Collect_Garbage_Button"
    And I wait few seconds
    And I click on "Waste_Type_Selector"
    And I wait few seconds
    When I press the down arrow key
    When I press the down arrow key
    And I click on "Polythene_Option"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Garbage_Submit"

  Scenario: Assign User Garbage Collect Multiple Type
    And I click on "Assigned_User_Button"
    And I wait few seconds
    And I click on "Collect_Garbage_Button"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Add_More_Waste_Type_Button"
    And I wait few seconds

    And I click on "Waste_Option_second_Multi"
    And I wait few seconds
    When I press the down arrow key
    And I click on "Cardboard_Option"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Add_More_Waste_Type_Button"
    And I wait few seconds

    And I click on "Waste_Option_Third_Multi"
    And I wait few seconds
    When I press the down arrow key
    When I press the down arrow key
    And I click on "Polythene_Option"
    And I wait few seconds
    And I click on "Weight_Input"
    And I wait few seconds
    When I clear text  "Weight_Input"
    And I wait few seconds
    And I use random number to the weight "After_Clear_Weight_Input"
    And I wait few seconds
    And I click on "Garbage_Submit"






