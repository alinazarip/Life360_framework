Feature: Contact Page Functionality

@wip
Scenario: User submits a contact form successfully
  Given user is on the Contact page
  When the user fills in the following information
    | email        | johnsmith@gmail.com    |
    | subject      | inquiry                |
    | description  | This is a test message |
    | phone number | 9179626181             |
  And user clicks submit button
  Then user should see a confirmation message



  Scenario: User submits a contact form entering letters in the phone number field
    Given user is on the Contact page
    When the user fills in the following information
      | email        | johnsmith@gmail.com    |
      | subject      | inquiry                |
      | description  | This is a test message |
      | phone number | abcd                   |

    Then the system should display an error message
    And the error message should indicate that the phone number is invalid







