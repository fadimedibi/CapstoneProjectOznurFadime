package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.time.Duration;
import utilities.ReusableMethods;


public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @When("User clicks on Microsoft365 module")
    public void user_clicks_on_module() {
        loginPage.microsoft365Link.click();
    }

    @Then("User enters valid email address {string} in the email field")
    public void user_enters_valid_email_address_in_the_email_field(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage.switchToChildWindow();
        loginPage.emailBox.sendKeys(string);
    }

    @Then("User press the Next button")
    public void user_press_the_Next_button() {
        loginPage.nextButton.click();
        ReusableMethods.wait(3);
    }

    @Then("User enters valid password {string} in the password field")
    public void user_enters_valid_password_in_the_password_field(String string) {
        loginPage.passwordBox.sendKeys(string);
        ReusableMethods.wait(3);
    }

    @Then("User press the Sign in button")
    public void user_press_the_Sign_in_button() {
        loginPage.sign_inButton.click();
        ReusableMethods.wait(3);
    }

    @Then("User clicks on the No button")
    public void user_clicks_on_the_No_button() {
        loginPage.NoButton.click();
        ReusableMethods.wait(3);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        ReusableMethods.wait(3);
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String pageTitle = Driver.get().getTitle();
        Assert.assertEquals(string, pageTitle);
    }

    @Then("User signs out from the Portal365")
    public void user_signs_out_from_the_Portal() {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.initialsButton.click();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.signOut.click();
    }

    @Then("page title should be {string} ")
    public void page_title_should_be_Sign_out(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String message = Driver.get().getTitle();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(string,message);
    }

    @Given("User enters invalid email address {string} in the email field")
    public void user_enters_invalid_email_address_in_the_email_field(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.switchToChildWindow();
        loginPage.emailBox.sendKeys(string);
    }

    @Given("User enters invalid password {string}in the password field")
    public void user_enters_invalid_password_WrongPassword111_in_the_password_field(String string) {
        loginPage.emailBox.sendKeys(string);
    }

    @Then("Page title should be {string}")
    public void user_sees_a_message_that_includes(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String message = Driver.get().getTitle();
        Assert.assertEquals(string, message);
    }

    @Given("User enters invalid password {string} in the password field")
    public void user_enters_invalid_password_in_the_password_field(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.switchToChildWindow();
        loginPage.passwordBox.sendKeys(string);
    }


    @Then("User sees a message that {string}")
    public void User_sees_a_message_that_Forgot_my_password(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String message = loginPage.forgotPassword.getText();
        Assert.assertEquals(string, message);
    }
}
