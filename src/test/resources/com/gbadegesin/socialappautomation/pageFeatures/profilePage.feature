Feature: Profile Page
     
 	#ValidateBasicProfileDetailsSteps
  @WebTest
  Scenario: Success - User Profile - Validate Basic Profile
    Given User is on the feeds page '/app/myFeeds'
    When User clicks on 'Profile' on the dashboard which navigates to my profile page
    Then User should see the basic profile with the following user details
       | firstName | Yuvraj               |
       | lastName  | Singh                |
       | phone     | 6471234567           |
       | email     | me@iyuvraajsingh.com |  
     

  #UpdateBasicProfileSteps
  @WebTest
  Scenario: Success - User Profile - Update Basic Profile
		Given User is on the profile page "/app/profile"
		When User updates profile with the following user details
		   | firstName | Idris                |
		   | lastName  | Adelabu              |
		   | password  | Password1%           |
		   | phone     | 1234567890           |
		   | email     | me@gbadeadelabu.com  |
		And User clicks 'Save' on the basic profile section
		Then User should see the message "Basic profile saved." on the profile page
     