Feature: Pet Store

  @BFST-01
  Scenario: BFST-01 - insert, get and update pet
    Given add pet
    When get pet
    Then update pet
    | Máximo recargado |
    