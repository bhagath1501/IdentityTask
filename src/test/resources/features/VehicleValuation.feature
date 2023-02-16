Feature: Vehicle valuation test feature

  @vehicleRegValidation @abd
  Scenario: Validate Vehicle Registration Number
    Given Read data from input text file
    When Read output text file and validate vehicle details
    Then validation is successful