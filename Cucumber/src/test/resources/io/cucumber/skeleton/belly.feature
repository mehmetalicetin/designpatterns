Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl

   Scenario: a little cukes
     Given I have 20 cukes in my belly
     When I wait 1 hour
     Then my belly should not growl