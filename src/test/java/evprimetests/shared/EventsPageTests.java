package evprimetests.shared;

import base.BaseEventTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventsPageTests extends BaseEventTest {

    @Test
    public void eventsPageContentValidationTest() {
        assertTrue(eventsPage.getActiveEventsCount() > 0);
        assertTrue(eventsPage.areEventTitlesNotEmpty());
        assertTrue(eventsPage.areEventDatesNotEmpty());
        assertTrue(eventsPage.areAllEventImagesDisplayed());
    }

    @Test
    public void eventsPageDetailedContentValidationTest() {
        assertEquals("12.09.2026", eventsPage.getEventDateText(eventTitle));
        assertTrue(eventsPage.getEventImageUrl(eventTitle).startsWith(image));
    }

    @Test
    public void clickEventNavigationTest() {
        eventsPage.clickEvent(eventTitle);

        assertEquals(eventTitle, eventDetailsPage.getEventTitleText());
    }

    @Test
    public void eventsPageTextColorsValidationTest() {
        assertEquals("#ffffff", eventsPage.getEventTitlesTextColor());
        assertEquals("#ffffff", eventsPage.getEventDatesTextColor());
    }

    @Test
    public void eventsPageFontValidationTest() {
        assertTrue(eventsPage.getEventTitlesFont().contains("Josefin Sans"));
        assertEquals("16px", eventsPage.getEventTitlesFontSize());

        assertTrue(eventsPage.getEventDatesFont().contains("Josefin Sans"));
        assertEquals("12px", eventsPage.getEventDatesFontSize());
    }
}
