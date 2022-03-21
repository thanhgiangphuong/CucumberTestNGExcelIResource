Feature: This is test scenario off Login Page

  @TC-01
  Scenario: @TC-01 - RememberMe checkbox isn't selected in default
    Given I open Login page
    Then I want to verify RememberMe checkbox isn't selected in default

  @TC-02
  Scenario Outline: @TC-02 - Alert displays when login with email blank
    Given I open Login page
    When I login with email blank and valid password is <validPassword>
    Then System displays the <alert> message under email field
    Examples:
      | validPassword | alert     |
      | Nguyen@123    | Required! |

  @TC-03
  Scenario Outline: @TC-03 - Alert displays when login with password blank
    Given I open Login page
    When I login with password blank and valid email is <validEmail>
    Then System displays the <alert> message under password field
    Examples:
      | validEmail                        | alert |
      | phuongthanhgiang+test37@gmail.com | Required! |

  @TC-04
  Scenario Outline: @TC-04 - Alert displays when login with email is wrong format
    Given I open Login page
    When I login with wrong format of email is <wrongEmailF> and valid password is <validPass>
    Then System displays the <alert> message in the email field
    Examples:
      | wrongEmailF                      | validPass  | alert                |
      | phuongthanhgiang+test37@gmailcom | Nguyen@123 | Invalid email format |

  @TC-05
  Scenario Outline: @TC-05 - Alert displays when login with invalid password
    Given I open Login page
    When I login with invalid password is <invalidPass> and valid email is <validEmail>
    Then System displays the <alert> message in the right top of page
    Examples:
      | invalidPass                       | validEmail | alert                         |
      | phuongthanhgiang+test37@gmail.com | 1234567    | Email or password is invalid. |

  @TC-06
  Scenario Outline: @TC-06 - System navigate to Explore Project page when login successfully
    Given I open Login page
    When I login with valid data are <email> and <password>
    Then System navigate to Explore Project page with <username> displayed
    Examples:
      | email                             | password   | username |
      | phuongthanhgiang+test37@gmail.com | Nguyen@123 | nguyen nguyen |