package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ConfigurationReader;
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
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
        } else {
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        Driver.close();
    }

}
