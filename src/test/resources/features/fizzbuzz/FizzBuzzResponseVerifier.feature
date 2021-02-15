@regression
Feature: FizzBuzz API calls returning valid response as per the requirement.
  Scenario: Calling FizzBuzz API passing multiples of 3 parameters.
    Given Prepare FizzBuzz post request param 3,6,9,15
    When call API
    Then validate API response
      |input|result         |
      |3    |Fizz           |
      |3    |Divided 3 by 5 |
      |6    |Fizz           |
      |6    |Divided 6 by 5 |
      |9    |Fizz           |
      |9    |Divided 9 by 5 |
      |15   |Fizzbuzz       |

  Scenario: Calling FizzBuzz API passing multiples of 5 parameters.
    Given Prepare FizzBuzz post request param 5,10,15
    When call API
    Then validate API response
      |input|result           |
      |5    |Divided 5 by 3   |
      |5    |Buzz             |
      |10   |Divided 10 by 3  |
      |10   |Buzz             |
      |15   |Fizzbuzz         |

  Scenario: Calling FizzBuzz API passing random valid parameters.
    Given Prepare FizzBuzz post request param 1,3,5,7
    When call API
    Then validate API response
      |input|result         |
      |1    |Divided 1 by 3 |
      |1    |Divided 1 by 5 |
      |3    |Fizz           |
      |3    |Divided 3 by 5 |
      |5    |Divided 5 by 3 |
      |5    |Buzz           |
      |7    |Divided 7 by 3 |
      |7    |Divided 7 by 5 |

  Scenario: Calling FizzBuzz API passing invalid alphanumeric parameter.
    Given Prepare FizzBuzz post request param 3,A
    When call API
    Then validate API response
      |input|result         |
      |3    |Fizz           |
      |3    |Divided 3 by 5 |
      |A    |Invalid Item   |


  Scenario: Calling FizzBuzz API passing invalid empty parameter.
    Given Prepare FizzBuzz post request param 3,,5
    When call API
    Then validate API response
      |input      |result               |
      |3          |Fizz                 |
      |3          |Divided 3 by 5       |
      |<empty>    |Invalid item         |
      |5          |Divided 5 by 3       |
      |5          |Buzz                 |

  Scenario: Calling FizzBuzz API passing invalid special character parameter.
    Given Prepare FizzBuzz post request param 3,%
    When call API
    Then validate API response
      |input      |result               |
      |3          |Fizz                 |
      |3          |Divided 3 by 5       |
      |%          |Invalid Item         |




