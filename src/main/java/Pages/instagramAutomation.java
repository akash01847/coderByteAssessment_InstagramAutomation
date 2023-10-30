package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;
import java.util.List;

public class instagramAutomation {
    WebDriver driver;
    WebDriverWait wait;
    String filePath = System.getProperty("user.dir") + "src/main/java/resources/logo.png";
    @FindBy(css = "input[aria-label='Phone number, username or email address']")
    WebElement username;
    @FindBy(css = "input[aria-label=\"Password\"]")
    WebElement password;
    @FindBy(css = "button[type='submit']") WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Home')]") WebElement homeButton;
    @FindBy(css = "button[type='button']") WebElement saveInfoButton;
    @FindBy(css = "div[role='button']") WebElement notNowButton;
    @FindBy(css = "button[class='_a9-- _a9_1']") WebElement turnOnNotification;
    @FindBy(xpath = "//span[contains(text(),'Profile')]") WebElement profileButton;
    @FindBy(xpath = "//span[contains(text(),'Create')]") WebElement createNewPostButton;
    @FindBy(css = "div[class=\"_ac7a\"]") WebElement createNewPostFormHeading;
    @FindBy(xpath = "//a[normalize-space()='Edit Profile']") WebElement editProfileButton;
    @FindBy(css = "h2.x1lliihq") WebElement profileName;
    @FindBy(css = "div[class=\"_ac7b _ac7d\"] div div") WebElement nextButton;
    @FindBy(css = "div[aria-label=\"Write a caption...\"]") WebElement addCaptionBox;
    @FindBy(css = "input[class=\"_aaie _aaig  _aaid _ag7n\"]") WebElement addLocation;
    @FindBy(css = "input[class=\"_aaie  _aaid _ag7n\"]") WebElement addAltText;
    @FindBy(xpath = "//span[normalize-space()='Advanced Settings']") WebElement advanceSetting;
    @FindBy(xpath = "//span[normalize-space()='Turn off commenting']") WebElement turnOffCommenting;
    @FindBy(css = "svg[aria-label=\"Back\"]") WebElement backButton;
    @FindBy(css = "div[class=\"_ac7a\"]") WebElement editHeading;
    @FindBy(css = "div[class=\"_ac7a\"]") WebElement cropHeading;
    @FindBy(css = "button[class=\"_a9-- _a9-_\"]") WebElement discardButton;
    By toggleButton = By.cssSelector("input[type=\"checkbox\"]");
    @FindBy(css = "button[class=\"_acan _acap _acas _aj1-\"]") WebElement selectFromComputerButton;
    public instagramAutomation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void userLogin() {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("coderbyteinstaautomation@yopmail.com");
        password.sendKeys("test321");
        loginButton.click();
    }

    public void navigateToProfile() {
        wait.until(ExpectedConditions.visibilityOf(homeButton));
        Log.info("Login Successful" + homeButton.getText());
        if (saveInfoButton.isDisplayed()) {
            notNowButton.click();
            wait.until(ExpectedConditions.visibilityOf(turnOnNotification));
            turnOnNotification.click();
        }
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        profileButton.click();
        wait.until(ExpectedConditions.visibilityOf(editProfileButton));
        Log.info("ProfilePage: " + editProfileButton.getText());
    }

    public boolean validateUserProfile() {
        String storeProfileName = profileName.getText();
        Log.info("UserName" + storeProfileName);
        return profileName.getText().contains(storeProfileName);
    }

    public void clickOnCreateNewPost() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(homeButton));
        Log.info("Login Successful" + homeButton.getText());
        if (saveInfoButton.isDisplayed()) {
            notNowButton.click();
            wait.until(ExpectedConditions.visibilityOf(turnOnNotification));
            turnOnNotification.click();
        }
        wait.until(ExpectedConditions.visibilityOf(createNewPostButton));
        createNewPostButton.click();
        wait.until(ExpectedConditions.visibilityOf(createNewPostFormHeading));
        Log.info(createNewPostFormHeading.getText());
        selectFromComputerButton.click();
        selectFromComputerButton.sendKeys(filePath);
        Log.info("File Uploaded Successfully.");
        Thread.sleep(5000);
    }

    public boolean proceedToPostEditingSection() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
        Thread.sleep(500);
        nextButton.click();
        wait.until(ExpectedConditions.visibilityOf(addCaptionBox));
        return addCaptionBox.isDisplayed();
    }

    public void addCaption() {
        addCaptionBox.sendKeys("Hey There");
    }

    public boolean addOtherInformation() {
        addLocation.sendKeys("Noida");
        addAltText.sendKeys("Testing");
        advanceSetting.click();
        List<WebElement> toggle = driver.findElements(toggleButton);
        for (WebElement Button : toggle) {
            Button.click();
        }
        return turnOffCommenting.isDisplayed();
    }

    public boolean navigateBackAndDiscardPost() {
        backButton.click();
        wait.until(ExpectedConditions.visibilityOf(editHeading));
        backButton.click();
        wait.until(ExpectedConditions.visibilityOf(cropHeading));
        backButton.click();
        wait.until(ExpectedConditions.visibilityOf(discardButton));
        discardButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectFromComputerButton));
        return selectFromComputerButton.getText().contains("Select From Computer");
    }

}
