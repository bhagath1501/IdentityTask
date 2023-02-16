Feature: Vehicle valuation test

  @vehicleRegValidation @abc
  Scenario: Validate Vehicle Registration Number
    Given Read data from input text file
    When Read output text file and validate vehicle details