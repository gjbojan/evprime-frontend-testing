package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPage extends BasePage {

    public EventsPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By eventImages = By.cssSelector("ul.MuiImageList-root > li");
    private final By eventTitles = By.cssSelector("li .MuiImageListItemBar-title");
    private final By eventDates = By.cssSelector("li .MuiImageListItemBar-subtitle");

    private By eventDateByTitle(String title) {
        return By.xpath("//div[normalize-space()='" + title + "']/ancestor::li//div[contains(@class,'MuiImageListItemBar-subtitle')]");
    }

    private By eventImageByTitle(String title) {
        return By.xpath("//div[normalize-space()='" + title + "']/ancestor::li//img");
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickEvent(String title) {
        click(eventImageByTitle(title));
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getEventDateText(String title) {
        return getText(eventDateByTitle(title));
    }

    // ==========================================
    // GET IMAGE ACTIONS
    // ==========================================
    public String getEventImageUrl(String title) {
        return getImage(eventImageByTitle(title));
    }

    // ==========================================
    // EVENT LIST ACTIONS
    // ==========================================
    public int getActiveEventsCount() {
        return getElementCount(eventImages);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean doesEventExist(String title) {
        return getElementCount(eventImageByTitle(title)) > 0;
    }

    public boolean areEventTitlesNotEmpty() {
        return areAllElementsNotEmpty(eventTitles);
    }

    public boolean areEventDatesNotEmpty() {
        return areAllElementsNotEmpty(eventDates);
    }

    public boolean areAllEventImagesDisplayed() {
        return areAllElementsDisplayed(eventImages);
    }

    // ==========================================
    // TEXT COLOR ACTIONS
    // ==========================================
    public String getEventTitlesTextColor() {
        return getElementColorAsHex(eventTitles, COLOR);
    }

    public String getEventDatesTextColor() {
        return getElementColorAsHex(eventDates, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getEventTitlesFont() {
        return getFont(eventTitles);
    }

    public String getEventTitlesFontSize() {
        return getFontSize(eventTitles);
    }

    public String getEventDatesFont() {
        return getFont(eventDates);
    }

    public String getEventDatesFontSize() {
        return getFontSize(eventDates);
    }
}
