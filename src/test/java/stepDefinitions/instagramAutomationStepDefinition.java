package stepDefinitions;

import Pages.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static utils.Base.driver;

public class instagramAutomationStepDefinition {

    PageObjectManager pom = new PageObjectManager(driver);

    @Given("I login through valid credentials")
    public void i_login_through_valid_credentials() {
            pom.getInstagramAutomation().userLogin();
    }
    @When("I navigate to profile page")
    public void i_navigate_to_profile_page() {
        pom.getInstagramAutomation().navigateToProfile();
    }
    @Then("I can see user profile")
    public void i_can_see_user_profile() {
        Assert.assertTrue(pom.getInstagramAutomation().validateUserProfile());
    }

    @When("I navigate to the create new post section and click on the select from computer option to upload an image")
    public void i_navigate_to_the_create_new_post_section_and_click_on_select_from_computer_the_option_to_upload_an_image() throws InterruptedException {
        pom.getInstagramAutomation().clickOnCreateNewPost();
    }
    @Then("Click on the next button to proceed to the post editing section")
    public void click_on_the_next_button_to_proceed_to_the_post_editing_section() throws InterruptedException {
        Assert.assertTrue(pom.getInstagramAutomation().proceedToPostEditingSection());
    }

    @When("I navigate to the create new post section and click on the select from computer option to upload an image and click on the next button to proceed to the post editing section")
    public void i_navigate_to_the_create_new_post_section_and_click_on_the_select_from_computer_option_to_upload_an_image_and_click_on_the_next_button_to_proceed_to_the_post_editing_section() throws InterruptedException {
        pom.getInstagramAutomation().clickOnCreateNewPost();
        pom.getInstagramAutomation().proceedToPostEditingSection();
    }

    @When("I add caption in caption box")
    public void i_add_caption_in_caption_box() {
        pom.getInstagramAutomation().addCaption();
    }
    @Then("I include location information for the post and Implement accessibility features for the post and Enable all advanced settings available for the post.")
    public void i_include_location_information_for_the_post_and_implement_accessibility_features_for_the_post_and_enable_all_advanced_settings_available_for_the_post() {
        Assert.assertTrue(pom.getInstagramAutomation().addOtherInformation());
    }

    @When("I navigate to the create new post section and added all the information completely")
    public void i_navigate_to_the_create_new_post_section_and_added_all_the_information_completely() throws InterruptedException {
        pom.getInstagramAutomation().clickOnCreateNewPost();
        pom.getInstagramAutomation().proceedToPostEditingSection();
        pom.getInstagramAutomation().addCaption();
        pom.getInstagramAutomation().addOtherInformation();
    }

    @Then("I navigate back to the initial step and discard the post before finalizing the upload and close the create new post dialog")
    public void i_navigate_back_to_the_initial_step_and_discard_the_post_before_finalizing_the_upload_and_close_the_create_new_post_dialog() {
        Assert.assertTrue(pom.getInstagramAutomation().navigateBackAndDiscardPost());
    }
}
