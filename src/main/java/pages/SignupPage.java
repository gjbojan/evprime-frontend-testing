package pages;

import base.BaseAuthenticationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BaseAuthenticationPage {

    public SignupPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By signupTitle = By.xpath("//div[normalize-space()='Create new user']");

    private final By loginButton = By.xpath("//button[normalize-space()='Log In']");

    private final By invalidEmailMessage = By.xpath("//li[normalize-space()='Invalid email.']");
    private final By emailExistsMessage = By.xpath("//li[normalize-space()='Email exists already.']");
    private final By invalidPasswordMessage = By.xpath("//li[normalize-space()='Invalid password. Must be at least 6 characters long.']");
    private final By signupValidationErrorMessage = By.xpath("//span[normalize-space()='User signup failed due to validation errors.']");

    // ==========================================
    // SIGNUP ACTION
    // ==========================================
    public void signup(String email, String password) {
        submitAuthForm(email, password);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickLoginButton() {
        click(loginButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getSignupPageTitleText() {
        return getText(signupTitle);
    }

    public String getLoginButtonText() {
        return getText(loginButton);
    }

    public String getInvalidEmailText() {
        return getText(invalidEmailMessage);
    }

    public String getSignupValidationErrorText() {
        return getText(signupValidationErrorMessage);
    }

    public String getEmailExistsText() {
        return getText(emailExistsMessage);
    }

    public String getInvalidPasswordText() {
        return getText(invalidPasswordMessage);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getLoginButtonHoverEffect() {
        hover(loginButton);
        waitForAnimation();

        return getElementColorAsHex(loginButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getLoginButtonBackgroundColor() {
        return getElementColorAsHex(loginButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getLoginButtonTextColor() {
        return getElementColorAsHex(loginButton, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getSignupPageTitleTextFont() {
        return getFont(signupTitle);
    }

    public String getSignupPageTitleTextFontSize() {
        return getFontSize(signupTitle);
    }

    public String getLoginButtonFont() {
        return getFont(loginButton);
    }

    public String getLoginButtonFontSize() {
        return getFontSize(loginButton);
    }

    public String getInvalidEmailTextFont() {
        return getFont(invalidEmailMessage);
    }

    public String getInvalidEmailTextFontSize() {
        return getFontSize(invalidEmailMessage);
    }

    public String getInvalidPasswordTextFont() {
        return getFont(invalidPasswordMessage);
    }

    public String getInvalidPasswordTextFontSize() {
        return getFontSize(invalidPasswordMessage);
    }

    public String getEmailExistsTextFont() {
        return getFont(emailExistsMessage);
    }

    public String getEmailExistsTextFontSize() {
        return getFontSize(emailExistsMessage);
    }

    public String getSignupValidationErrorTextFont() {
        return getFont(signupValidationErrorMessage);
    }

    public String getSignupValidationErrorTextFontSize() {
        return getFontSize(signupValidationErrorMessage);
    }
}
