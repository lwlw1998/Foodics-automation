@smoke
Feature: F01_Login | Users could login
  # Positive Scenario
  Scenario: User Navigate to google page
    Given  User Entre a word "Facebook"
    And Delete the word
    And rewrite newWord "Twitter"
    And Validate that number of results appears on UI
    And Validate search suggestion displayed
