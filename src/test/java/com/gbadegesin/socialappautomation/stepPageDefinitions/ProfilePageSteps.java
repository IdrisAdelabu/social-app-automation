package com.gbadegesin.socialappautomation.stepPageDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gbadegesin.socialappautomation.pageObjects.ProfilePage;
import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePageSteps {
	
	@Autowired
    ProfilePage profilePage;
	
	@Given("User is on the complete user profile page {string}")
	public void user_is_on_the_complete_user_profile_page(String profileRoute) {
	    assertEquals(profileRoute,this.profilePage.getPageRoute());
	}

	@When("User clicks on the 'Upload Photo' button with image {string}")
	public void user_clicks_on_the_upload_photo_button_with_image(String imagePath)  {
		this.profilePage.openImageSelector(imagePath);
	}

	@Then("A cropper should appear on the complete user profile page")
	public void a_cropper_should_appear_on_complete_user_profile_page()  {
		assertTrue(this.profilePage.validateCropperModal());
	}

	@When("User clicks on the 'Crop' button to finalize the image on the complete user profile page")
	public void user_clicks_on_the_crop_button_to_finalize_the_image_on_complete_user_profile_page() {
	    this.profilePage.clickCrop();
	}

	@And("User enters the new user profile details")
	public void user_enters_the_new_user_profile_details(DataTable data) {
	    this.profilePage.setBio(data.asMap().get("bio"));
	    this.profilePage.setCity(data.asMap().get("city"));
	    this.profilePage.setCountry(data.asMap().get("country"));
	    this.profilePage.setHeadline(data.asMap().get("headline"));
	}

	@And("User clicks 'Save' on the complete profile page")
	public void user_clicks_save_on_the_complete_profile_page() {
	    this.profilePage.clickSave();
	}

	@Then("User should navigate to {string} dashboard")
	public void user_should_navigate_to_dashboard(String dashboardRoute) {
	    assertEquals(dashboardRoute, this.profilePage.getPageRoute());
	}
	
	@Given("User is on the feeds page {string}")
	public void user_is_on_the_feeds_page(String feedsRoute) {
	    assertEquals(feedsRoute,this.profilePage.getPageRoute());
	}

	@When("User clicks on {string} on the dashboard which navigates to my profile page")
	public void user_is_on_the_register_page(String profilePageLink) {
		this.profilePage.openProfilePage(profilePageLink);
	}
	
	@Then("User should see the basic profile with the following user details")
	public void user_should_see_basic_profile_details(DataTable data) {
		
		assertEquals(data.asMap().get("firstName"), this.profilePage.getFirstName());
		assertEquals(data.asMap().get("lastName"), this.profilePage.getLastName());
		assertEquals(data.asMap().get("phone"), this.profilePage.getPhone());
		assertEquals(data.asMap().get("email"), this.profilePage.getEmail());
	}
	
	@Given("User is on the profile page {string}")
	public void user_is_on_the_profile_page(String profileRoute) {
	    assertEquals(profileRoute,this.profilePage.getPageRoute());
	}
	
	@When("User updates profile with the following user details")
	public void user_updates_profile_details(DataTable data) {

		this.profilePage.setFirstName(data.asMap().get("firstName"));
		this.profilePage.setLastName(data.asMap().get("lastName"));
		this.profilePage.setPassword(data.asMap().get("password"));
		this.profilePage.setPhone(data.asMap().get("phone"));
		this.profilePage.setEmail(data.asMap().get("email"));
	}
	
	@And("User clicks 'Save' on the basic profile section")
	public void user_clicks_save_on_the_basic_profile_section() {
	    this.profilePage.clickSaveToUpdateProfile();
	}
	
	@Then("User should see the message {string} on the profile page")
	public void user_should_see_the_message_on_the_register_page(String message) {
		assertEquals(message, this.profilePage.getMessage());
	}
}
