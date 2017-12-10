Feature: the version can be retrieved
  Scenario: Add products to the shopping cart
    Given An empty shopping cart
    And a product, Dove Soap with a unit price of 39.99
    And another product, Axe Deo with a unit price of 99.99
    And a tax rate of 12.5%
    When The user adds 2 Dove Soaps to the shopping cart
    And then adds 2 Axe Deo’s to the shopping cart
    Then The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
    And the shopping cart should contain 2 Axe Deo's each with a unit price of 99.99
    And the total tax amount should equal 35.00
    And the shopping cart’s total price should equal 314.96