package evprimetests.authenticated;

import base.BaseNoPasswordPopupTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CreateNewEventPage;
import pages.EventDetailsPage;
import pages.EventsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewEventPageTests extends BaseNoPasswordPopupTest {

    private CreateNewEventPage createNewEventPage;
    private EventDetailsPage eventDetailsPage;
    private EventsPage eventsPage;

    private final String eventTitle = "Handball Match" + System.currentTimeMillis();
    private static final String image = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/SAP_Arena_Handball_ausverkauft.jpg/1280px-SAP_Arena_Handball_ausverkauft.jpg";
    private static final String invalidImage = "upload.wikimedia.org/wikipedia/commons/9/93/Est%C3%A1dio_Municipal_de_Aveiro_aerial_view.jpg";
    private static final String description = "Fast pacing, hard hits, and spectacular jump shots. Experience the raw intensity of elite handball live as the top teams clash";


    @BeforeEach
    public void setUpCreateNewEventPage() {
        loginPrerequisite();

        navigateToPage("events/new");
        createNewEventPage = new CreateNewEventPage(driver);
        eventDetailsPage = new EventDetailsPage(driver);
        eventsPage = new EventsPage(driver);
    }

    @Test
    public void createNewEventPageTextValidationTest() {
        assertEquals("Event Title", createNewEventPage.getEventTitleLabelText());
        assertEquals("Event Image", createNewEventPage.getEventImageLabelText());
        assertEquals("Event Date", createNewEventPage.getEventDateLabelText());
        assertEquals("Event Location", createNewEventPage.getEventLocationLabelText());
        assertEquals("Event Description", createNewEventPage.getEventDescriptionLabelText());
        assertEquals("CREATE EVENT", createNewEventPage.getCreateEventButtonText());
    }

    @Test
    public void successfulEventCreationTest() {
        try {
            createNewEventPage.createEvent(eventTitle, image, "04.07.2026", "Skopje, Macedonia", description);

            assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
            assertTrue(eventsPage.doesEventExist(eventTitle));
        }
        finally {
            eventsPage.clickEvent(eventTitle);
            eventDetailsPage.deleteAnEventDeleteOption();
        }
    }

    @Test
    public void createEventWithEmptyFieldsNegativeTest() {
        createNewEventPage.createEvent("", "", "", "", "");

        assertEquals("Unexpected Application Error!", createNewEventPage.getUnexpectedApplicationErrorText());
    }

    @Test
    public void invalidEventImageURLCreateNewEventNegativeTest() {
        createNewEventPage.createEvent(eventTitle, invalidImage, "22.02.2002", "Skopje", "Test");

        assertEquals("Unexpected Application Error!", createNewEventPage.getUnexpectedApplicationErrorText());
    }

    @Test
    public void createNewEventPageDefaultColorsValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.6)", createNewEventPage.getEventTitleLabelDefaultColor());
        assertEquals("#ffffff", createNewEventPage.getCreateEventButtonTextColor());
        assertEquals("#304ffe", createNewEventPage.getCreateEventButtonDefaultBackgroundColor());
    }

    @Test
    public void createNewEventPageHoverEffectValidationTest() {
        assertEquals("rgb(33, 55, 177)", createNewEventPage.getCreateEventButtonHoverEffect());
    }

    @Test
    public void createNewEventPageFocusColorsValidationTest() {
        assertEquals("#304ffe", createNewEventPage.getEventTitleLabelFocusedColor());
    }

    @Test
    public void createNewEventPageFontValidationTest() {
        assertTrue(createNewEventPage.getEventTitleLabelTextFont().contains("Josefin Sans"));
        assertEquals("16px", createNewEventPage.getEventTitleLabelTextFontSize());

        assertTrue(createNewEventPage.getCreateEventButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", createNewEventPage.getCreateEventButtonTextFontSize());
    }
}
