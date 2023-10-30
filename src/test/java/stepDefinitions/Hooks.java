package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks extends Base {


    @Given("I launch the driver")
    public void i_launch_the_driver() throws IOException {
        initializeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        sc = scenario;
    }

    @After(order = 1)
    public void screenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] ss = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(ss, "png", "After error message");
            String name = scenario.getName();
            File f = screenshot.getScreenshotAs(OutputType.FILE);
            File file = new File(System.getProperty("user.dir") + "/ScreenShot/" + name + ".png");
            FileUtils.copyFile(f, file);
        }
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }

    @Then("I quit the driver")
    public void i_quit_the_driver() throws InterruptedException {
        if ((driver != null)) {
            driver.quit();
        }
    }
}