package evprimetests.authenticated;

import base.BaseEventTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.EditEventPage;

import static org.junit.jupiter.api.Assertions.*;

public class EventDetailsPageAuthenticatedTests extends BaseEventTest {

    private EditEventPage editEventPage;

    @BeforeEach
    public void setUpEventAuthenticatedDetailsPage() {
        eventsPage.clickEvent(eventTitle);
        editEventPage = new EditEventPage(driver);
    }

    @Test
    public void eventDetailsPageAuthenticatedTextTest() {
        assertEquals("EDIT EVENT", eventDetailsPage.getEditEventButtonText());
        assertEquals("BACK TO EVENTS", eventDetailsPage.getBackToEventsButtonText());

        assertEquals("DELETE EVENT", eventDetailsPage.getDeleteEventButtonText());
        eventDetailsPage.openDeletePopup();
        assertEquals("Are you sure you want to delete this event?", eventDetailsPage.getDeleteEventPopupTitleText());
        assertEquals("DELETE", eventDetailsPage.getDeleteEventPopupDeleteOptionText());
        assertEquals("NO", eventDetailsPage.getDeleteEventPopupNoOptionText());
    }

    @Test
    public void deleteEventOptionNoChosenTest() {
        eventDetailsPage.deleteAnEventNoOption();

        assertFalse(eventDetailsPage.isDeletePopupDisplayed());
    }

    @Test
    public void successfullyDeleteAnEventTest() {
        eventDetailsPage.deleteAnEventDeleteOption();

        shouldDeleteEvent = false;

        assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
        assertFalse(eventsPage.doesEventExist(eventTitle));
    }

    @Test
    public void functionalUsageOfEditEventButtonTest() {
        eventDetailsPage.clickEditEventButton();

        assertTrue(editEventPage.isUpdateEventButtonDisplayed());
    }

    @Test
    public void eventDetailsPageAuthenticatedDefaultColorsValidationTest() {
        assertEquals("#304ffe", eventDetailsPage.getEditEventButtonDefaultBackgroundColor());
        assertEquals("#ffffff", eventDetailsPage.getEditEventButtonTextColor());
        assertEquals("#d32f2f", eventDetailsPage.getDeleteEventButtonDefaultBackgroundColor());
        assertEquals("#ffffff", eventDetailsPage.getDeleteEventButtonTextColor());

        eventDetailsPage.openDeletePopup();
        assertEquals("#d32f2f", eventDetailsPage.getDeleteEventPopupDeleteButtonDefaultBackgroundColor());
        assertEquals("#ffffff", eventDetailsPage.getDeleteEventPopupDeleteButtonTextColor());
        assertEquals("#9c27b0", eventDetailsPage.getDeleteEventPopupNoButtonDefaultBackgroundColor());
        assertEquals("#ffffff", eventDetailsPage.getDeleteEventPopupNoButtonTextColor());
    }

    @Test
    public void eventDetailsPageAuthenticatedHoverEffectValidationTest() {
        assertEquals("#c62828", eventDetailsPage.getDeleteEventButtonHoverEffect());
        assertEquals("rgb(33, 55, 177)", eventDetailsPage.getEditEventButtonHoverEffect());

        eventDetailsPage.openDeletePopup();
        assertEquals("#c62828", eventDetailsPage.getDeleteEventPopupDeleteButtonHoverEffect());
        assertEquals("#7b1fa2", eventDetailsPage.getDeleteEventPopupNoButtonHoverEffect());
    }

    @Test
    public void eventDetailsPageAuthenticatedFontValidationTest() {
        assertTrue(eventDetailsPage.getDeleteEventButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getDeleteEventButtonTextFontSize());

        assertTrue(eventDetailsPage.getEditEventButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getEditEventButtonTextFontSize());

        eventDetailsPage.openDeletePopup();
        assertTrue(eventDetailsPage.getDeleteEventPopupTitleTextFont().contains("Josefin Sans"));
        assertEquals("24px", eventDetailsPage.getDeleteEventPopupTitleTextFontSize());

        assertTrue(eventDetailsPage.getDeleteEventPopupDeleteButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getDeleteEventPopupDeleteButtonTextFontSize());

        assertTrue(eventDetailsPage.getDeleteEventPopupNoButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getDeleteEventPopupNoButtonTextFontSize());
    }
}
