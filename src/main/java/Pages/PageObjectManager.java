package Pages;

import org.openqa.selenium.WebDriver;
import utils.Base;

public class PageObjectManager extends Base {
    public static WebDriver driver;
    instagramAutomation instaAutomation;

    public PageObjectManager(WebDriver driver){
        PageObjectManager.driver =driver;
    }

    public instagramAutomation getInstagramAutomation() {
        instaAutomation = new instagramAutomation(driver);
        return instaAutomation;
    }


}
