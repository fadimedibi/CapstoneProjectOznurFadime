package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpenAI_Validator;
import utilities.Driver;

import java.io.IOException;
import java.util.List;

import pages.SeleniumTextExtractor_OpenAI;


public class PortalValidation_OpenAI_StepDefinitions {

    SeleniumTextExtractor_OpenAI selTextExt = new SeleniumTextExtractor_OpenAI();

    @When("I am on the NAU Portal page")
    public void i_am_on_the_nau_portal_page() {
        selTextExt.NAUPortal.click();
    }

    @Then("I validate the {string} using AI")
    public void i_validate_using_ai(String contentType) throws IOException {
        List<String> items;
        String expectedItems;

        switch (contentType) {
            case "tabs":
                items = SeleniumTextExtractor_OpenAI.getTabTexts(Driver.get());
                expectedItems = "Home, Alumni, Admissions";
                break;
            case "customContents":
                items = SeleniumTextExtractor_OpenAI.getCustomContentPortlets(Driver.get());
                expectedItems = "Email, Library, Office 365, IT Tickets";
                break;
            case "quickLinks":
                items = SeleniumTextExtractor_OpenAI.getQuickLinkTexts(Driver.get());
                expectedItems = "Privacy policy, About us, Contact us, Campus Map FAILING";
                break;
            default:
                throw new IllegalArgumentException("Invalid content type: " + contentType);
        }

        // Send the validation request
        String response = OpenAI_Validator.validateWithOpenAI(contentType, items, expectedItems);
        System.out.println("AI Validation Response for " + contentType + ": " + response);

        // Check validation success
        boolean isValid = OpenAI_Validator.isValidationSuccessful(response);
        if (!isValid) {
            throw new AssertionError("Validation failed for " + contentType + ". Response: " + response);
        }
    }
}
