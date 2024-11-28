package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import pages.RequestInfoPage;
import utilities.ReusableMethods;

import java.time.Duration;


public class RequestInfoStepDefinitions {
    RequestInfoPage requestInfoPage = new RequestInfoPage();

    @When("User clicks on the Request Info module")
    public void user_clicks_on_the_Request_Info_module() {
        requestInfoPage.requestInfo.click();
    }

    @Then("Verify request info form title should be {string}")
    public void verify_request_info_form_title_should_be(String string) {
        String title = requestInfoPage.requestInfoFormTitle.getText();
        Assert.assertEquals(string, title);
    }

    @Then("verify Captcha checkbox is displayed")
    public void verify_Captcha_checkbox_is_displayed() {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get().switchTo().frame(requestInfoPage.iframe);
        Assert.assertTrue(requestInfoPage.requestInfoCaptcha.isDisplayed());
    }

    @When("User fill out all information boxes excluding Athlete information")
    public void user_fill_out_all_information_boxes_excluding_Athlete_information() {
        requestInfoPage.requestInfoFillOut();
    }

    @When("User fill out all information boxes including Athlete information")
    public void user_fill_out_all_information_boxes_including_Athlete_information() {
        requestInfoPage.requestInfoFillOut();
        requestInfoPage.requestInfoAthlete.click();
        Select select = new Select(requestInfoPage.requestInfo_IamPlaying);
        select.selectByVisibleText("Football");
        requestInfoPage.requestInfo_height.sendKeys("1.90 cm");
        requestInfoPage.requestInfo_weight.sendKeys("75 kg");
    }

    @When("User fill out all information boxes")
    public void user_fill_out_all_information_boxes() {
        requestInfoPage.requestInfoFillOut();
    }

    @Then("verify Submit button is not clickable")
    public void verify_Submit_button_is_not_clickable() {
        Assert.assertFalse(requestInfoPage.requestInfoSubmitButton.isEnabled());
    }
}
