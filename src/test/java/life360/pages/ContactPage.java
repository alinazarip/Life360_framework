package life360.pages;

import life360.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    public ContactPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "request_anonymous_requester_email")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@name='request[subject]']")
    public WebElement subject;

    @FindBy(id = "tinymce")
    public WebElement description;

    @FindBy(className = "nesty-input")
    public WebElement platform;

    @FindBy(xpath = "//input[contains(@data-tagger,'Android')]")
    public WebElement clickAndroid;

    @FindBy(id = "request_custom_fields_360038922173")
    public WebElement phoneNumber;


    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;








}

