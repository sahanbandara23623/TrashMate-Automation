Feature: Add New Admin to System

  Background:
    Given I have opened the system

  Scenario: Add New Admin
    And I wait few seconds
    And I type "Admin" to the "Login_User_Name_Field"
    And I wait few seconds
    And I type "admin123" to the "Login_Password_Field"
    And I wait few seconds
    And I click on "Login_Button"
    And I wait few seconds
    And I wait few seconds
    And I click on "Admin_Tab"
    And I wait few seconds
    And I click on "Add_Button"
    And I wait few seconds
    And I click on "UserRole_Drop_Down"
    And I wait few seconds
    When I press the down arrow and then enter key
    And I wait few seconds
    And I click on "Employee_Name"
    And I wait few seconds
    And I type "Charles Carter" to the "Employee_Name"
    And I wait few seconds
    When I press the down arrow and then enter key
    And I wait few seconds
    And I click on "Status_Dro_Down"
    And I wait few seconds
    When I press the down arrow and then enter key
    And I wait few seconds
    And I click on "Username"
    And I wait few seconds
    And I generate a random UserName to the "Username"
    And I wait few seconds
    And I click on "Password"
    And I type "Test@123" to the "Password"
    And I wait few seconds
    And I click on "Confirm_Password"
    And I type "Test@123" to the "Confirm_Password"
    And I wait few seconds
    And I click on "Save_Button"
    And I wait few seconds
    And I wait few seconds







