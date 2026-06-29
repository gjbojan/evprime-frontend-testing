package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    public ContactPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By contactTitle = By.xpath("//h2[normalize-space()='Want to reach out?']");
    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By messageField = By.cssSelector("textarea[name='description']:not([aria-hidden='true'])");
    private final By messageLabel = By.xpath("//label[starts-with(normalize-space(),'Message')]");
    private final By sendButton = By.cssSelector("button[type='submit']");

    private final By addressLabel = By.xpath("//p[normalize-space()='Address']");
    private final By emailLabel = By.xpath("//p[normalize-space()='Email']");
    private final By phoneNumberLabel = By.xpath("//p[normalize-space()='Phone Number']");

    private final By addressValue = By.xpath("//p[normalize-space()='Rampo Lefkata 1']");
    private final By emailValue = By.xpath("//p[normalize-space()='ev@rampo.com']");
    private final By phoneNumberValue = By.xpath("//p[normalize-space()='+389 75 500 000']");

    private final By unexpectedApplicationErrorTitle = By.xpath("//h2[normalize-space()='Unexpected Application Error!']");

    private final By methodNotAllowedErrorTitle = By.xpath("//h3[normalize-space()='405 Method Not Allowed']");

    // ==========================================
    // SEND ACTION
    // ==========================================
    public void sendMessage(String name, String email, String message) {
        if(!name.isBlank()) {
            type(nameField, name);
        }

        if(!email.isBlank()) {
            type(emailField, email);
        }

        if(!message.isBlank()) {
            type(messageField, message);
        }

        click(sendButton);
        waitForAnimation();
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getContactPageTitleText() {
        return getText(contactTitle);
    }

    public String getMessageLabelText() {
        return getText(messageLabel);
    }

    public String getSendButtonText() {
        return getText(sendButton);
    }

    public String getAddressLabelText() {
        return getText(addressLabel);
    }

    public String getEmailLabelText() {
        return getText(emailLabel);
    }

    public String getPhoneNumberLabelText() {
        return getText(phoneNumberLabel);
    }

    public String getAddressValueText() {
        return getText(addressValue);
    }

    public String getEmailValueText() {
        return getText(emailValue);
    }

    public String getPhoneNumberValueText() {
        return getText(phoneNumberValue);
    }

    public String getUnexpectedApplicationErrorText() {
        return getText(unexpectedApplicationErrorTitle);
    }

    public String getMethodNotAllowedErrorText() {
        return getText(methodNotAllowedErrorTitle);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isContactPageTitleDisplayed() {
        return isDisplayed(contactTitle);
    }

    // ==========================================
    // LABEL DEFAULT COLOR ACTIONS
    // ==========================================
    public String getMessageFieldLabelDefaultColor() {
        return getElementColorAsRgba(messageLabel, COLOR);
    }

    // ==========================================
    // FOCUS EFFECT ACTIONS
    // ==========================================
    public String getMessageFieldLabelFocusedColor() {
        click(messageField);
        waitForAnimation();

        return getElementColorAsHex(messageLabel, COLOR);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getSendButtonHoverEffect() {
        hover(sendButton);
        waitForAnimation();

        return getElementColorAsRgb(sendButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getSendButtonDefaultBackgroundColor() {
        return getElementColorAsHex(sendButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getSendButtonTextColor() {
        return getElementColorAsHex(sendButton, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getContactTitleFont() {
        return getFont(contactTitle);
    }

    public String getContactTitleFontSize() {
        return getFontSize(contactTitle);
    }

    public String getMessageLabelFont() {
        return getFont(messageLabel);
    }

    public String getMessageLabelFontSize() {
        return getFontSize(messageLabel);
    }

    public String getAddressLabelFont() {
        return getFont(addressLabel);
    }

    public String getAddressLabelFontSize() {
        return getFontSize(addressLabel);
    }

    public String getAddressValueTextFont() {
        return getFont(addressValue);
    }

    public String getAddressValueTextFontSize() {
        return getFontSize(addressValue);
    }

    public String getEmailLabelFont() {
        return getFont(emailLabel);
    }

    public String getEmailLabelFontSize() {
        return getFontSize(emailLabel);
    }

    public String getEmailValueTextFont() {
        return getFont(emailValue);
    }

    public String getEmailValueTextFontSize() {
        return getFontSize(emailValue);
    }

    public String getPhoneNumberLabelFont() {
        return getFont(phoneNumberLabel);
    }

    public String getPhoneNumberLabelFontSize() {
        return getFontSize(phoneNumberLabel);
    }

    public String getPhoneNumberValueTextFont() {
        return getFont(phoneNumberValue);
    }

    public String getPhoneNumberValueTextFontSize() {
        return getFontSize(phoneNumberValue);
    }

    public String getSendButtonTextFont() {
        return getFont(sendButton);
    }

    public String getSendButtonTextFontSize() {
        return getFontSize(sendButton);
    }
}
