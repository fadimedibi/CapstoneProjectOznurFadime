package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.Driver;

import java.time.Duration;

import utilities.ReusableMethods;
import pages.MainPage;

public class MainPageStepDefinitions {
    MainPage mainPage = new MainPage();

    @Then("verify that logo is available")
    public void verify_that_logo_is_available() {
        Assert.assertTrue(mainPage.logo.isDisplayed());
    }

    @Then("verify that Gift Shop is clickable")
    public void verify_that_Gift_Shop_is_clickable() {
        Assert.assertTrue(mainPage.giftShop.isEnabled());
    }

    @Given("User scrolls down the page")
    public void user_scrolls_down_the_page() {
        ReusableMethods.wait(3);
        ReusableMethods.scrollToElement(mainPage.contactInf);
    }

    @Then("User sees the contact information")
    public void user_sees_the_contact_information() {
        ReusableMethods.wait(10);
        String contactInf = mainPage.contactInf.getText();
        System.out.println(contactInf);
        String expectedContactInf =
                "11929 W AIRPORT BLVD\n" +
                        "HOUSTON, TEXAS 77477";
        Assert.assertEquals(expectedContactInf, contactInf);
    }

    @When("User searches {string}")
    public void user_searches(String string) {
        ReusableMethods.wait(5);
        mainPage.searchBox(string);
    }

    @Then("Expected title {string} should include search value")
    public void expected_title_should_include_search_value(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.checkTitleInNewWindow(string);
    }


    @When("User searches invalid {string}")
    public void user_searches_invalid(String string) {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.searchBox(string);
    }

    @Then("User should see {string} as a warning message")
    public void user_should_see_as_a_warning_message(String string) {
        String warningMessage = mainPage.warningMessage.getText();
        Assert.assertEquals(string, warningMessage);

    }
}