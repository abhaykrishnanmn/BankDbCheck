Feature: Banking Validation

#  Scenario: Verify user can signup and login to the page
#    Given user login to the website
#    When user is on the login page click on signup
#    And user enters the valid signup details
#    When user enters the username "username" and password "password"
#    Then user verifies the login page with title welcome "fName"
#
#  Scenario: Verify user's checking account details
#    Given user login to the website
#    When user enters the username "username" and password "password"
#    Then click on checking and create a new account
#    And provide name "name" and initial deposit "deposit"
#    Then verify name "name", account type "accType", ownership "owner" and deposit "deposit" are displayed
#
#  Scenario: Create savings account
#    Given user login to the website
#    When user enters the username "username" and password "password"
#    Then click on savings account

  Scenario: Transfer Money
    Given user login to the website
    When user enters the username "username" and password "password"
#    Then click on checking and create a new account
#    And provide name "name" and initial deposit "deposit"
    And transfer money to other account
#    Then verify name "name", account type "accType", ownership "owner" and deposit "deposit" are displayed

  Scenario: Logout
    Given user login to the website
    When user enters the username "username" and password "password"
    Then Logout

