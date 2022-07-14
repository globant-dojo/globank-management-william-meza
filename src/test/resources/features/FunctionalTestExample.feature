#Feature: Functional tests rest
#  Scenario: Functional Breaker guesses a number between 1 and 10
#    Given Functional the Maker has chosen a number 5
#    #  When the Breaker makes a guess
#    Then Functional the Maker is asked "ok" if breaker guessed 5
#    Then Functional the Maker is asked "fail" if breaker guessed 6
Feature: Feature test accounts
  Scenario: Scenario save and findAll
    Given given account number 200140
    Then Response code is 200