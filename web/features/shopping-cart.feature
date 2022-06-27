@ShoppingCart
Feature: Shopping cart

  @BFST-01
  Scenario: BFST-01 - Verify that the product was added to the shopping cart
    Given the user go to page
    | https://www.demoblaze.com/index.html |
    When sign up user
    And log in
    And add laptop to shopping cart
    | MacBook air |
    Then verify laptop in shopping cart
    | MacBook air |
    And log out
