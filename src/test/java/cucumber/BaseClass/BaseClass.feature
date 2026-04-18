@tag
  Feature: purchase order from the website

    Background:
      Given I land on the login page
    #noinspection GherkinBrokenTableInspection
    @tag2
   Scenario Outline:Positive Scenario-submit order
      When I login with username "<Username>" and password "<password>"
      And I add the products "<productName>"
      Then the user checks out "<productName>" and submits the order

      Examples:
        | Username                 |password |productName|
        | santoshshevale@gmail.com |Pass@1234| ADIDAS ORIGINAL |
