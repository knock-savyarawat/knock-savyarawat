@KNOCK 
Feature: Book Tour

  @BookTour 
  Scenario: Booking a tour for tomorrow 
  	Given I navigate to "defined url"
  	And I switch to frame "iFrameOptionMenu"
    When I click on "scheduleTour" button
    And I switch to default content
    And I switch to frame "iFrameBookingOptions"
    And I select tomorrow date on "datePicker"
    And I select "2" index dropdown on "selectTime"
    And I enter text "Savya" on element "firstName"
    And I enter text "Rawat" on element "lastName"
    And I enter email on element "email"
    And I enter numeric data on element "phone"
    And I enter text "Safe Tour " on element "message"
    And I select dropdown element "selectBed" based on value "1 bedroom"
    And I click on "bookTour" button
   Then I verify element "confirmation" contains text "You're booked"
    
