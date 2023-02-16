Feature: Vehicle valuation test

  @vehicleRegValidation @abc @1
  Scenario: Validate Vehicle Registration Number
    Given Read data from input text file
    When Read output text file and validate vehicle details