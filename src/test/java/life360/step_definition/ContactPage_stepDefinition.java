package life360.step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import life360.pages.ContactPage;
import life360.utilities.ConfigurationReader;
import life360.utilities.Driver;

import java.util.Map;

public class ContactPage_stepDefinition {


    ContactPage contactPage = new ContactPage();

    @Given("user is on the Contact page")
    public void user_is_on_the_contact_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("contactPage"));

    }
    @When("the user fills in the following information")
    public void the_user_fills_in_the_following_information(Map<String, String> information) {
        contactPage.emailAddress.sendKeys(information.get("email"));
        contactPage.subject.sendKeys(information.get("inquiry"));
        contactPage.description.sendKeys(information.get("description"));
        contactPage.platform.click();
        contactPage.clickAndroid.click();
        contactPage.phoneNumber.sendKeys(information.get("phone number"));



    }
    @When("user clicks submit button")
    public void user_clicks_submit_button() {

        contactPage.submitButton.click();

    }
    @Then("user should see a confirmation message")
    public void user_should_see_a_confirmation_message() {




    }

    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
    }

    @And("the error message should indicate that the phone number is invalid")
    public void theErrorMessageShouldIndicateThatThePhoneNumberIsInvalid() {
    }


    }

