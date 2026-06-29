package evprimetests.guest;

import base.BaseTest;
import components.AddEventButton;
import components.Sidebar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends BaseTest {

    private LoginPage loginPage;
    private Sidebar sidebar;
    private AddEventButton addEventButton;

    @BeforeEach
    public void setUpLoginPage() {
        navigateToPage("auth?mode=login");

        loginPage = new LoginPage(driver);
        sidebar = new Sidebar(driver);
        addEventButton = new AddEventButton(driver);
    }

    @Test
    public void loginPageTextValidationTest() {
        assertEquals("Log in", loginPage.getLoginPageTitleText());
        assertEquals("E-Mail", loginPage.getEmailFieldText());
        assertEquals("Password", loginPage.getPasswordFieldText());
        assertEquals("GO", loginPage.getGoButtonText());
        assertEquals("CREATE USER", loginPage.getCreateUserButtonText());
    }

    @Test
    public void successfulLoginTest() {
        loginPage.login("testuser@email.com", "testuser123");

        assertEquals("http://localhost:3000/", driver.getCurrentUrl());
        assertTrue(sidebar.isLogoutButtonDisplayed());
        assertFalse(sidebar.isLoginButtonDisplayed());
        assertTrue(addEventButton.isAddEventButtonDisplayed());
    }

    @ParameterizedTest
    @ValueSource(strings = {"nonexisting@mail.com", ""})
    public void invalidEmailNegativeLoginTest(String email) {
        loginPage.login(email, "nonexisting123");

        assertEquals("Authentication failed.", loginPage.getAuthenticationFailedText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalidpass123", ""})
    public void invalidPasswordWithNonExistingEmailNegativeLoginTest(String password) {
        loginPage.login("nonexisting@mail.com", password);

        assertEquals("Authentication failed.", loginPage.getAuthenticationFailedText());
    }

    @Test
    public void bothFieldsEmptyNegativeLoginTest() {
        loginPage.login("", "");

        assertEquals("Authentication failed.", loginPage.getAuthenticationFailedText());
    }

    @Test
    public void registeredEmailWrongPasswordNegativeLoginTest() {
        loginPage.login("testuser@email.com", "wrongpassword123");

        assertEquals("Invalid email or password entered.", loginPage.getInvalidEmailOrPasswordText());
        assertEquals("Invalid credentials.", loginPage.getInvalidCredentialsText());
    }

    @Test
    public void createUserButtonNavigatesToSignupPageTest() {
        loginPage.clickCreateUserButton();

        assertEquals("http://localhost:3000/auth?mode=signup", driver.getCurrentUrl());
    }

    @Test
    public void loginPageDefaultColorsValidationTest() {
        assertEquals("#304ffe", loginPage.getGoButtonBackgroundColor());
        assertEquals("#9c27b0", loginPage.getCreateUserButtonBackgroundColor());

        assertEquals("#ffffff", loginPage.getGoButtonTextColor());
        assertEquals("#ffffff", loginPage.getCreateUserButtonTextColor());
    }

    @Test
    public void loginPageHoverEffectValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.87)", loginPage.getEmailBorderHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.87)", loginPage.getPasswordBorderHoverEffect());
        assertEquals("rgb(33, 55, 177)", loginPage.getGoButtonHoverEffect());
        assertEquals("#7b1fa2", loginPage.getCreateUserButtonHoverEffect());
    }

    @Test
    public void loginPageFocusColorsValidationTest() {
        assertEquals("#304ffe", loginPage.getEmailFieldFocusedBorderColor());
        assertEquals("#304ffe", loginPage.getEmailFieldFocusedLabelColor());

        assertEquals("#304ffe", loginPage.getPasswordFieldFocusedBorderColor());
        assertEquals("#304ffe", loginPage.getPasswordFieldFocusedLabelColor());
    }

    @Test
    public void loginPageFontValidationTest() {
        assertTrue(loginPage.getLoginPageTitleTextFont().contains("Josefin Sans"));
        assertEquals("24px", loginPage.getLoginPageTitleTextFontSize());

        assertTrue(loginPage.getEmailLabelFont().contains("Josefin Sans"));
        assertEquals("16px", loginPage.getEmailLabelFontSize());

        assertTrue(loginPage.getPasswordLabelFont().contains("Josefin Sans"));
        assertEquals("16px", loginPage.getPasswordLabelFontSize());

        assertTrue(loginPage.getGoButtonFont().contains("Josefin Sans"));
        assertEquals("14px", loginPage.getGoButtonFontSize());

        assertTrue(loginPage.getCreateUserButtonFont().contains("Josefin Sans"));
        assertEquals("14px", loginPage.getCreateUserButtonFontSize());

        loginPage.clickGoButton();
        assertTrue(loginPage.getAuthenticationFailedTextFont().contains("Josefin Sans"));
        assertEquals("16px", loginPage.getAuthenticationFailedTextFontSize());

        loginPage.login("testuser@email.com", "test123");
        assertTrue(loginPage.getInvalidEmailOrPasswordTextFont().contains("Josefin Sans"));
        assertEquals("16px", loginPage.getInvalidEmailOrPasswordTextFontSize());
        assertTrue(loginPage.getInvalidCredentialsTextFont().contains("Josefin Sans"));
        assertEquals("16px", loginPage.getInvalidCredentialsTextFontSize());
    }
}
