package evprimetests.shared;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ContactPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPageTests extends BaseTest {

    private ContactPage contactPage;

    @BeforeEach
    public void setUpContactPage() {
        navigateToPage("contact");

        contactPage = new ContactPage(driver);
    }

    @Test
    public void contactPageTextValidationTest() {
        assertEquals("Want to reach out?", contactPage.getContactPageTitleText());
        assertTrue(contactPage.getMessageLabelText().contains("Message"));
        assertEquals("SEND", contactPage.getSendButtonText());
        assertEquals("Address", contactPage.getAddressLabelText());
        assertEquals("Rampo Lefkata 1", contactPage.getAddressValueText());
        assertEquals("Email", contactPage.getEmailLabelText());
        assertEquals("ev@rampo.com", contactPage.getEmailValueText());
        assertEquals("Phone Number", contactPage.getPhoneNumberLabelText());
        assertEquals("+389 75 500 000", contactPage.getPhoneNumberValueText());
    }

    @Test
    public void sendContactMessageTest() {
        contactPage.sendMessage("testuser", "testuser@email.com", "This is a test message");

        assertEquals("Unexpected Application Error!", contactPage.getUnexpectedApplicationErrorText());
        assertEquals("405 Method Not Allowed", contactPage.getMethodNotAllowedErrorText());
    }

    @ParameterizedTest
    @CsvSource({
            "'','',''",
            "'','testuser@email.com',''",
            "'','testuser@email.com','this is a test message'",
            "'testuser','',''",
            "'testuser','','this is a test message'",
            "'testuser','testuseremail.com',''",
            "'testuser','testuseremail.com','this is a test message'",
            "'testuser','testuser@email.com',''"
    })
    public void invalidContactFormSubmissionNegativeTest(String name, String email, String message) {
        contactPage.sendMessage(name, email, message);

        assertTrue(contactPage.isContactPageTitleDisplayed());
    }

    @Test
    public void contactPageDefaultColorsValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.6)", contactPage.getMessageFieldLabelDefaultColor());
        assertEquals("#304ffe", contactPage.getSendButtonDefaultBackgroundColor());
        assertEquals("#ffffff", contactPage.getSendButtonTextColor());
    }

    @Test
    public void contactPageHoverEffectValidationTest() {
        assertEquals("rgb(33, 55, 177)", contactPage.getSendButtonHoverEffect());
    }

    @Test
    public void contactPageFocusColorsValidationTest() {
        assertEquals("#304ffe", contactPage.getMessageFieldLabelFocusedColor());
    }

    @Test
    public void contactPageFontValidationTest() {
        assertTrue(contactPage.getContactTitleFont().contains("Josefin Sans"));
        assertEquals("60px", contactPage.getContactTitleFontSize());

        assertTrue(contactPage.getMessageLabelFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getMessageLabelFontSize());

        assertTrue(contactPage.getSendButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", contactPage.getSendButtonTextFontSize());

        assertTrue(contactPage.getAddressLabelFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getAddressLabelFontSize());
        assertTrue(contactPage.getAddressValueTextFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getAddressValueTextFontSize());

        assertTrue(contactPage.getEmailLabelFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getEmailLabelFontSize());
        assertTrue(contactPage.getEmailValueTextFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getEmailValueTextFontSize());

        assertTrue(contactPage.getPhoneNumberLabelFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getPhoneNumberLabelFontSize());
        assertTrue(contactPage.getPhoneNumberValueTextFont().contains("Josefin Sans"));
        assertEquals("16px", contactPage.getPhoneNumberValueTextFontSize());
    }
}

