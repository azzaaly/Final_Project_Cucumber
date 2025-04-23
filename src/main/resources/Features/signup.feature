Feature: SignUp Feature
  @Regression
  Scenario: Signup With Valid Credentials
    Given user opens homepage & click on Sign Up Button
    When user enters valid username & password & press on sign up button
    Then success message appears & user is switched to homePage