package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChatGPTValidator;
import utilities.Driver;
import java.io.IOException;
import java.util.List;
import pages.SeleniumTextExtractorForChatGPT;


public class PortalValidationChatGPTStepDefinitions {

    SeleniumTextExtractorForChatGPT selTextExt = new SeleniumTextExtractorForChatGPT();

    @When("I am on the NAU Portal page")
    public void i_am_on_the_nau_portal_page() {
        selTextExt.NAUPortal.click();

    }

    @Then("I validate the tabs using AI")
    public void i_validate_the_tabs_using_ai() throws IOException {
        // Extract the tabs from the portal
        List<String> tabs = SeleniumTextExtractorForChatGPT.getTabTexts(Driver.get());

        // Validate using ChatGPT API
        String response1 = ChatGPTValidator.validateWithChatGPTTabs(tabs);

        // Output the response for now (you could use assertions to verify)
        System.out.println("AI Validation Response: " + response1);

    }
    @Then("I validate the quickLinks using AI")
    public void i_validate_the_quickLinks_using_ai() throws IOException {
        List<String> quickLinks = SeleniumTextExtractorForChatGPT.getQuickLinkTexts(Driver.get());

        // Validate using ChatGPT API
        String response2 = ChatGPTValidator.validateWithChatGPTLinks(quickLinks);

        // Output the response for now (you could use assertions to verify)
        System.out.println("AI Validation Response: " + response2);


    }
}
