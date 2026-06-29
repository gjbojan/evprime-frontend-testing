package pages;

import base.BaseAuthenticationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseAuthenticationPage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By loginTitle = By.xpath("//div[normalize-space()='Log in']");

    private final By createUserButton = By.xpath("//button[normalize-space()='Create User']");

    private final By authenticationFailedMessage = By.xpath("//span[normalize-space()='Authentication failed.']");
    private final By invalidEmailOrPasswordMessage = By.xpath("//li[normalize-space()='Invalid email or password entered.']");
    private final By invalidCredentialsMessage = By.xpath("//span[normalize-space()='Invalid credentials.']");


    // ==========================================
    // LOGIN ACTION
    // ==========================================
    public void login(String email, String password) {
        submitAuthForm(email, password);
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickCreateUserButton() {
        click(createUserButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getLoginPageTitleText() {
        return getText(loginTitle);
    }

    public String getCreateUserButtonText() {
        return getText(createUserButton);
    }

    public String getAuthenticationFailedText() {
        return getText(authenticationFailedMessage);
    }

    public String getInvalidEmailOrPasswordText() {
        return getText(invalidEmailOrPasswordMessage);
    }

    public String getInvalidCredentialsText() {
        return getText(invalidCredentialsMessage);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getCreateUserButtonHoverEffect() {
        hover(createUserButton);
        waitForAnimation();

        return getElementColorAsHex(createUserButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getCreateUserButtonBackgroundColor() {
        return getElementColorAsHex(createUserButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getCreateUserButtonTextColor() {
        return getElementColorAsHex(createUserButton, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getLoginPageTitleTextFont() {
        return getFont(loginTitle);
    }

    public String getLoginPageTitleTextFontSize() {
        return getFontSize(loginTitle);
    }

    public String getCreateUserButtonFont() {
        return getFont(createUserButton);
    }

    public String getCreateUserButtonFontSize() {
        return getFontSize(createUserButton);
    }

    public String getAuthenticationFailedTextFont() {
        return getFont(authenticationFailedMessage);
    }

    public String getAuthenticationFailedTextFontSize() {
        return getFontSize(authenticationFailedMessage);
    }

    public String getInvalidEmailOrPasswordTextFont() {
        return getFont(invalidEmailOrPasswordMessage);
    }

    public String getInvalidEmailOrPasswordTextFontSize() {
        return getFontSize(invalidEmailOrPasswordMessage);
    }

    public String getInvalidCredentialsTextFont() {
        return getFont(invalidCredentialsMessage);
    }

    public String getInvalidCredentialsTextFontSize() {
        return getFontSize(invalidCredentialsMessage);
    }
}
