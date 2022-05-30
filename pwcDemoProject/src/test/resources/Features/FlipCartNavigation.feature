Feature: This feature is use to test 
  User is able to open Flipcart site and able to validate the mobile proce in cart page 


  
  Scenario Outline: User is able to navigate Flipcart side and validate the proce of 6th mobile in PD page 
    Given User is able to launch the Flipcart site using "<keyword>"
    When User cancel the popup
   	And Search "Products" in searchbox
   	Then User is able to see List of Mobiles 
   	When User navigate to sixth mobile to store the price of mobile
   	And User clicks on the mobile descriptions
   	Then User navigate to Product defination page
   	When User clicks on Add to cart button 
   	Then User is able to validate the price 
   	
   

    Examples: 
      | keyword | 
      | TC001 | 
