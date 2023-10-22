Feature: Login page aplikasi saucedemo

  Scenario Outline: Success login
    Given : User navigate to website
    When : Enter valid <account>
    And : Enter valid <password>
    And : Click on Log In button
    Then : User in on dashboard page <status>
    Examples:
      | account           | password      | status  |
      | standart_user     | secret_sauce  | success |
      | standart_user     | failed        | failed  |

  Scenario: Failed login
    Given : User navigate to website
    When : Enter valid <account>
    And : Enter valid <password>
    And : Click on Log In button
    Then : User get error message