package evprimetests.guest;

import base.BaseEventTest;
import components.Sidebar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventDetailsPageGuestTests extends BaseEventTest {

    @BeforeEach
    public void setUpEventDetailsPage() {
        Sidebar sidebar = new Sidebar(driver);
        sidebar.clickLogoutOption();
        navigateToPage("events");
        eventsPage.clickEvent(eventTitle);
    }

    @Test
    public void eventDetailsPageEventHealthCheck() {
        assertTrue(eventDetailsPage.isEventTitleDisplayed());
        assertTrue(eventDetailsPage.isEventDateDisplayed());
        assertTrue(eventDetailsPage.isEventLocationDisplayed());
        assertTrue(eventDetailsPage.isEventDescriptionDisplayed());
        assertTrue(eventDetailsPage.isEventImageDisplayed());
    }

    @Test
    public void eventDetailsPageFullValidationTest() {
        assertEquals(eventTitle, eventDetailsPage.getEventTitleText());
        assertEquals(image, eventDetailsPage.getEventImage());
        assertEquals("12.09.2026", eventDetailsPage.getEventDateText());
        assertEquals("Tokyo, Japan", eventDetailsPage.getEventLocationText());
        assertEquals(description, eventDetailsPage.getEventDescriptionText());
        assertEquals("BACK TO EVENTS", eventDetailsPage.getBackToEventsButtonText());
    }

    @Test
    public void functionalUsageOfBackToEventsButtonTest() {
        eventDetailsPage.clickBackToEventsButton();

        assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
    }

    @Test
    public void eventDetailsPageDefaultColorsValidationTest() {
        assertEquals("#9c27b0", eventDetailsPage.getBackToEventsButtonDefaultBackgroundColor());
        assertEquals("#ffffff", eventDetailsPage.getBackToEventsButtonTextColor());
    }

    @Test
    public void eventDetailsPageHoverEffectValidationTest() {
        assertEquals("#7b1fa2", eventDetailsPage.getBackToEventsButtonHoverEffect());
    }

    @Test
    public void eventDetailsPageFontValidationTest() {
        assertTrue(eventDetailsPage.getEventTitleFont().contains("Josefin Sans"));
        assertEquals("60px", eventDetailsPage.getEventTitleFontSize());

        assertTrue(eventDetailsPage.getEventDateFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getEventDateFontSize());

        assertTrue(eventDetailsPage.getEventLocationFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getEventLocationFontSize());

        assertTrue(eventDetailsPage.getEventDescriptionFont().contains("Josefin Sans"));
        assertEquals("16px", eventDetailsPage.getEventDescriptionFontSize());

        assertTrue(eventDetailsPage.getBackToEventsButtonTextFont().contains("Josefin Sans"));
        assertEquals("14px", eventDetailsPage.getBackToEventsButtonTextFontSize());
    }

    @AfterEach
    public void tearDownEventDetailsPage() {
        loginPrerequisite();
    }
}
