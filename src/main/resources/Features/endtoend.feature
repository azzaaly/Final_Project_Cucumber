Feature: End To End Purchase Flow
  Background:
    Given user opens homepage & click on Log in Button
    When  the user logs in with username "Test_2025" and password "123456"
    Scenario: Add two products to cart and complete purchase
      When user adds  first product "Iphone 6 32gb" to the cart
      And user adds second product "Nexus 6" to the cart
      When users navigates to the cart
      Then the cart should contains the products
      |Product Names | Prices |
      |Nexus 6       |650     |
      |Iphone 6 32gb | 790    |
      And the total price should be 1440
      When users enters on places the order with:
      |Name | Country |city|Card |Month|Year|
      |AZZA |Egypt    |cairo|123 |10   |2020|
      Then the confirmation message should be "Thank you for your purchase!"

