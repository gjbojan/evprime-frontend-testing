package evprimetests.authenticated;

import base.BaseEventTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.EditEventPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditEventPageTests extends BaseEventTest {

    private static final String invalidImage = "upload.wikimedia.org/wikipedia/commons/9/93/Est%C3%A1dio_Municipal_de_Aveiro_aerial_view.jpg";

    private final String updatedEventTitle = "Football Match V2" + System.currentTimeMillis();
    private static final String updatedImageUrl = "https://upload.wikimedia.org/wikipedia/commons/0/0b/To%C5%A1e_Proeski_Arena_1.jpg";
    private static final String updatedDescription = "A football match between Macedonia and Serbia";


    private EditEventPage editEventPage;

    @BeforeEach
    public void setUpEditEventPage() {
        eventsPage.clickEvent(eventTitle);
        eventDetailsPage.clickEditEventButton();

        editEventPage = new EditEventPage(driver);
    }

    @Test
    public void editEventPageTextValidationTest() {
        assertEquals("Event Title", editEventPage.getEventTitleLabelText());
        assertEquals("Event Image", editEventPage.getEventImageLabelText());
        assertEquals("Event Date", editEventPage.getEventDateLabelText());
        assertEquals("Event Location", editEventPage.getEventLocationLabelText());
        assertEquals("Event Description", editEventPage.getEventDescriptionLabelText());
        assertEquals("UPDATE EVENT", editEventPage.getUpdateEventButtonText());
    }

    @Test
    public void clickableUpdateEventButtonWithoutModifyingTest() {
        editEventPage.clickUpdateEventButton();

        assertTrue(eventDetailsPage.isDeleteButtonDisplayed());
    }

    @Test
    public void successfulUpdateOfAnEventTest() {
        editEventPage.updateEvent(updatedEventTitle, updatedImageUrl, "23.07.2026", "Skopje, Macedonia", updatedDescription);

        assertEquals(updatedEventTitle, eventDetailsPage.getEventTitleText());
        assertEquals(updatedImageUrl, eventDetailsPage.getEventImage());
        assertEquals("23.07.2026", eventDetailsPage.getEventDateText());
        assertEquals("Skopje, Macedonia", eventDetailsPage.getEventLocationText());
        assertEquals(updatedDescription, eventDetailsPage.getEventDescriptionText());
        assertTrue(eventDetailsPage.isDeleteButtonDisplayed());

        eventTitle = updatedEventTitle;
    }

    @Test
    public void updateEventWithEmptyFieldsNegativeTest() {
        editEventPage.updateEvent("", "", "", "", "");

        assertEquals("Unexpected Application Error!", editEventPage.getUnexpectedApplicationErrorText());
    }

    @Test
    public void invalidEventImageUrlEditEventNegativeTest() {
        editEventPage.updateEvent(eventTitle, invalidImage, "22.02.2002", "Skopje", "Test");

        assertEquals("Unexpected Application Error!", editEventPage.getUnexpectedApplicationErrorText());
    }

    @Test
    public void editEventPageDefaultColorsValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.6)", editEventPage.getEventTitleLabelDefaultColor());
        assertEquals("#ffffff", editEventPage.getUpdateEventButtonTextColor());
        assertEquals("#2e7d32", editEventPage.getUpdateEventButtonDefaultBackgroundColor());
    }

    @Test
    public void editEventPageHoverEffectValidationTest() {
        assertEquals("#1b5e20", editEventPage.getUpdateEventButtonHoverEffect());
    }

    @Test
    public void editEventPageFocusColorsValidationTest() {
        assertEquals("#304ffe", editEventPage.getEventTitleLabelFocusedColor());
    }

    @Test
    public void editEventPageFontValidationTest() {
        assertTrue(editEventPage.getEventTitleLabelTextFont().contains("Josefin Sans"));
        assertEquals("16px", editEventPage.getEventTitleLabelTextFontSize());

        assertTrue(editEventPage.getUpdateEventButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", editEventPage.getUpdateEventButtonTextFontSize());
    }
}
