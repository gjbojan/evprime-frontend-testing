package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.CreateNewEventPage;
import pages.EventDetailsPage;
import pages.EventsPage;


public abstract class BaseEventTest extends BaseNoPasswordPopupTest {

    protected CreateNewEventPage createNewEventPage;
    protected EventsPage eventsPage;
    protected EventDetailsPage eventDetailsPage;

    protected boolean shouldDeleteEvent = true;

    protected String eventTitle;
    protected final String image = "https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/05/a0005279/img/basic/a0005279_main.jpg";
    protected final String description = "Where JDM heritage meets future performance under the neon glow. Join the ultimate Tokyo midnight gathering";

    @BeforeEach
    public void createAnEvent() {
        loginPrerequisite();

        createNewEventPage = new CreateNewEventPage(driver);
        eventsPage = new EventsPage(driver);
        eventDetailsPage = new EventDetailsPage(driver);

        eventTitle = "Tokyo Car Meet" + System.currentTimeMillis();

        navigateToPage("events/new");
        createNewEventPage.createEvent(eventTitle, image, "12.09.2026", "Tokyo, Japan", description);
    }

    @AfterEach
    public void deleteTheEvent() {
        if(!shouldDeleteEvent) {
            shouldDeleteEvent = true;
            return;
        }

        navigateToPage("events");
        eventsPage.clickEvent(eventTitle);
        eventDetailsPage.deleteAnEventDeleteOption();
    }
}
