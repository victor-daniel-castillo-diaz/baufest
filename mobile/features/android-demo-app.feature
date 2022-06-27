@AndroidDemoApp
Feature: Android Demo App

  @BFST-01
  Scenario: BFST-01 - Verify sign up, login and form section
    Given sign up user
    When log in
    Then complete fields of form section

  @BFST-02
  Scenario: BFST-02 - Test Webview
    Given search word
    | browser |
    When exit search
    Then navigate to tab
    | Docs |
    And navigate to tab
    | API |
    And navigate to tab
    | Blog |
    And navigate to tab
    | Contribute |
    And navigate to tab
    | Community |
    And navigate to tab
    | v7 |
