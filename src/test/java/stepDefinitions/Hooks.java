package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ConfigurationReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setup() {
        ConfigurationReader.getProperty("browser");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
            // Save screenshot to file for future reference in the report folder
            File srcFile = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/cucumber-reports/screenshots/failed-scenario-" + scenario.getName() + ".png";
            FileUtils.copyFile(srcFile, new File(screenshotPath));

            // Print path for verification
            System.out.println("Screenshot saved to: " + screenshotPath);
        } else {
            System.out.println("Cleanup!");
            System.out.println("Test completed successfully!");
        }
        Driver.close();
    }

}
