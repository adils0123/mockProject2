Feature: Purchase process on Demo Web Shop

Scenario: Purchase a Desktop from Demo Web Shop
    Given User is on Demo Web Shop homepage
    When User clicks on Computers link
    And User selects Desktops
    And User selects the first desktop
    And User adds the desktop to the cart
    And User navigates to cart and proceeds to checkout
    Then Order summary should be displayed