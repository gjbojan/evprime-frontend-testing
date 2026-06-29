package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseAuthenticationPage extends BasePage {

    public BaseAuthenticationPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");

    private final By goButton = By.xpath("//button[normalize-space()='Go']");

    private final By emailLabel = By.xpath("//label[normalize-space()='E-Mail']");
    private final By emailBorder = By.xpath("//input[@name='email']/following-sibling::fieldset");
    private final By passwordLabel = By.xpath("//label[normalize-space()='Password']");
    private final By passwordBorder = By.xpath("//input[@name='password']/following-sibling::fieldset");

    // ==========================================
    // LOGIN / SIGNUP ACTION
    // ==========================================
    public void submitAuthForm(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        clickGoButton();
        waitForAnimation();
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickEmailField() {
        click(emailField);
    }

    public void clickPasswordField() {
        click(passwordField);
    }

    public void clickGoButton() {
        click(goButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getEmailFieldText() {
        return getText(emailLabel);
    }

    public String getPasswordFieldText() {
        return getText(passwordLabel);
    }

    public String getGoButtonText() {
        return getText(goButton);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getEmailBorderHoverEffect() {
        hover(emailBorder);
        waitForAnimation();

        return getElementColorAsRgba(emailBorder, BORDER_COLOR);
    }

    public String getPasswordBorderHoverEffect() {
        hover(passwordBorder);
        waitForAnimation();

        return getElementColorAsRgba(passwordBorder, BORDER_COLOR);
    }

    public String getGoButtonHoverEffect() {
        hover(goButton);
        waitForAnimation();

        return getElementColorAsRgb(goButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getGoButtonBackgroundColor() {
        return getElementColorAsHex(goButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getGoButtonTextColor() {
        return getElementColorAsHex(goButton, COLOR);
    }

    // ==========================================
    // FOCUS EFFECT ACTIONS
    // ==========================================
    public String getEmailFieldFocusedBorderColor() {
        clickEmailField();

        return getElementColorAsHex(emailBorder, BORDER_COLOR);
    }

    public String getEmailFieldFocusedLabelColor() {
        clickEmailField();
        waitForAnimation();

        return getElementColorAsHex(emailLabel, COLOR);
    }

    public String getPasswordFieldFocusedBorderColor() {
        clickPasswordField();

        return getElementColorAsHex(passwordBorder, BORDER_COLOR);
    }

    public String getPasswordFieldFocusedLabelColor() {
        clickPasswordField();
        waitForAnimation();

        return getElementColorAsHex(passwordLabel, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getEmailLabelFont() {
        return getFont(emailLabel);
    }

    public String getEmailLabelFontSize() {
        return getFontSize(emailLabel);
    }

    public String getPasswordLabelFont() {
        return getFont(passwordLabel);
    }

    public String getPasswordLabelFontSize() {
        return getFontSize(passwordLabel);
    }

    public String getGoButtonFont() {
        return getFont(goButton);
    }

    public String getGoButtonFontSize() {
        return getFontSize(goButton);
    }

}
