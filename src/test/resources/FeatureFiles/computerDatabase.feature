Feature: Computer database
  As a user of the computer database site
  In order to add my new computer details to the database Or update Or remove
  I need to go the site and add my new computer details.

  Background:
    Given the navigated to the site

  @automated
  Scenario: Verify the user landed to computer database site
    Then the user verifies the name of the site is "Computer database"

  @automated
  Scenario: User can able to add a new computer to the database
    And the user clicks on add a new computer link
    When the user adds a new computer
    Then the computer is successfully added to the database

  @automated
  Scenario: User can able find the computer details by search filter
    And the user like to search for "ACE" computer
    When the user clicks on filter by name button
    Then the successfully able to get the "ACE" computer in the list

  @automated
  Scenario: Remove the computer from database
    And the user like to search for "ACE" computer
    And the user clicks on filter by name button
    And the user clicks on "ACE" computer link from list
    When the user delete the entry
    Then the computer successfully deleted from database