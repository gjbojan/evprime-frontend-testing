package evprimetests.guest;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SignupPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupPageTests extends BaseTest {

    private SignupPage signupPage;

    @BeforeEach
    public void setUpSignupPage() {
        navigateToPage("auth?mode=signup");

        signupPage = new SignupPage(driver);
    }

    @Test
    public void signupPageTextValidationTest() {
        assertEquals("Create new user", signupPage.getSignupPageTitleText());
        assertEquals("E-Mail", signupPage.getEmailFieldText());
        assertEquals("Password", signupPage.getPasswordFieldText());
        assertEquals("GO", signupPage.getGoButtonText());
        assertEquals("LOG IN", signupPage.getLoginButtonText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"frontendtest123", "test12", "test123"})
    public void successfulSignupTest(String password) {
        String email = "automation" + System.currentTimeMillis() + "@mail.com";
        signupPage.signup(email, password);

        assertEquals("http://localhost:3000/", driver.getCurrentUrl());
    }

    @ParameterizedTest
    @ValueSource(strings = {"frontendtestemail.com", ""})
    public void invalidEmailNegativeSignupTest(String email) {
        signupPage.signup(email, "frontendtest123");

        assertEquals("Invalid email.", signupPage.getInvalidEmailText());
        assertEquals("User signup failed due to validation errors.", signupPage.getSignupValidationErrorText());
    }

    @Test
    public void emailExistsAlreadyNegativeSignupTest() {
        signupPage.signup("testuser@email.com", "existinguser123");

        assertEquals("Email exists already.", signupPage.getEmailExistsText());
        assertEquals("User signup failed due to validation errors.", signupPage.getSignupValidationErrorText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad", "bad12", ""})
    public void invalidPasswordNegativeSignupTest(String password) {
        signupPage.signup("negativecase@email.com", password);

        assertEquals("Invalid password. Must be at least 6 characters long.", signupPage.getInvalidPasswordText());
        assertEquals("User signup failed due to validation errors.", signupPage.getSignupValidationErrorText());
    }

    @ParameterizedTest
    @CsvSource({
            "frontendtestemail.com,bad12",
            "'',''"
    })
    public void invalidEmailAndPasswordNegativeSignupTest(String email, String password) {
        signupPage.signup(email, password);

        assertEquals("Invalid email.", signupPage.getInvalidEmailText());
        assertEquals("Invalid password. Must be at least 6 characters long.", signupPage.getInvalidPasswordText());
        assertEquals("User signup failed due to validation errors.", signupPage.getSignupValidationErrorText());
    }

    @Test
    public void emailExistsAndInvalidPasswordNegativeSignupTest() {
        signupPage.signup("testuser@email.com", "bad12");

        assertEquals("Email exists already.", signupPage.getEmailExistsText());
        assertEquals("Invalid password. Must be at least 6 characters long.", signupPage.getInvalidPasswordText());
        assertEquals("User signup failed due to validation errors.", signupPage.getSignupValidationErrorText());
    }

    @Test
    public void loginButtonNavigatesToLoginPageTest() {
        signupPage.clickLoginButton();

        assertEquals("http://localhost:3000/auth?mode=login", driver.getCurrentUrl());
    }

    @Test
    public void signupPageDefaultColorsValidationTest() {
        assertEquals("#304ffe", signupPage.getGoButtonBackgroundColor());
        assertEquals("#9c27b0", signupPage.getLoginButtonBackgroundColor());

        assertEquals("#ffffff", signupPage.getGoButtonTextColor());
        assertEquals("#ffffff", signupPage.getLoginButtonTextColor());
    }

    @Test
    public void signupPageHoverEffectValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.87)", signupPage.getEmailBorderHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.87)", signupPage.getPasswordBorderHoverEffect());
        assertEquals("rgb(33, 55, 177)", signupPage.getGoButtonHoverEffect());
        assertEquals("#7b1fa2", signupPage.getLoginButtonHoverEffect());
    }

    @Test
    public void signupPageFocusColorsValidationTest() {
        assertEquals("#304ffe", signupPage.getEmailFieldFocusedBorderColor());
        assertEquals("#304ffe", signupPage.getEmailFieldFocusedLabelColor());

        assertEquals("#304ffe", signupPage.getPasswordFieldFocusedBorderColor());
        assertEquals("#304ffe", signupPage.getPasswordFieldFocusedLabelColor());
    }

    @Test
    public void signupPageFontValidationTest() {
        assertTrue(signupPage.getSignupPageTitleTextFont().contains("Josefin Sans"));
        assertEquals("24px", signupPage.getSignupPageTitleTextFontSize());

        assertTrue(signupPage.getEmailLabelFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getEmailLabelFontSize());

        assertTrue(signupPage.getPasswordLabelFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getPasswordLabelFontSize());

        assertTrue(signupPage.getGoButtonFont().contains("Josefin Sans"));
        assertEquals("14px", signupPage.getGoButtonFontSize());

        assertTrue(signupPage.getLoginButtonFont().contains("Josefin Sans"));
        assertEquals("14px", signupPage.getLoginButtonFontSize());

        signupPage.clickGoButton();
        assertTrue(signupPage.getInvalidEmailTextFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getInvalidEmailTextFontSize());
        assertTrue(signupPage.getInvalidPasswordTextFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getInvalidPasswordTextFontSize());
        assertTrue(signupPage.getSignupValidationErrorTextFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getSignupValidationErrorTextFontSize());

        signupPage.signup("testuser@email.com", "");
        assertTrue(signupPage.getEmailExistsTextFont().contains("Josefin Sans"));
        assertEquals("16px", signupPage.getEmailExistsTextFontSize());
    }
}
