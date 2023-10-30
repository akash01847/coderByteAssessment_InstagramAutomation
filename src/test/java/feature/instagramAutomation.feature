Feature: Admin Skills Functionality

  @instagramAutomation
  Scenario: Verify successful login and user profile visibility.
    Given I launch the driver
    Given I login through valid credentials
    When I navigate to profile page
    Then I can see user profile
    Then I quit the driver


  Scenario: Create New Post
    Given I launch the driver
    Given I login through valid credentials
    When I navigate to the create new post section and click on the select from computer option to upload an image
    Then Click on the next button to proceed to the post editing section

  Scenario: Post Editing
    Given I launch the driver
    Given I login through valid credentials
    When I navigate to the create new post section and click on the select from computer option to upload an image and click on the next button to proceed to the post editing section
    When I add caption in caption box
    Then I include location information for the post and Implement accessibility features for the post and Enable all advanced settings available for the post.

  Scenario: Handling Post Creation Dialog
    Given I launch the driver
    Given I login through valid credentials
    When I navigate to the create new post section and added all the information completely
    Then I navigate back to the initial step and discard the post before finalizing the upload and close the create new post dialog

