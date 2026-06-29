package pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEventPage extends BasePage {

    public EditEventPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By eventTitleLabel = By.xpath("//label[normalize-space()='Event Title']");
    private final By eventTitleField = By.name("title");
    private final By eventImageLabel = By.xpath("//label[normalize-space()='Event Image']");
    private final By eventImageField = By.name("image");
    private final By eventDateLabel = By.xpath("//label[normalize-space()='Event Date']");
    private final By eventDateField = By.name("date");
    private final By eventLocationLabel = By.xpath("//label[normalize-space()='Event Location']");
    private final By eventLocationField = By.name("location");
    private final By eventDescriptionLabel = By.xpath("//label[normalize-space()='Event Description']");
    private final By eventDescriptionField = By.cssSelector("textarea[name='description']");

    private final By updateEventButton = By.cssSelector("button[type='submit']");

    private final By unexpectedApplicationErrorTitle = By.xpath("//h2[normalize-space()='Unexpected Application Error!']");

    // ==========================================
    // UPDATE OF AN EVENT ACTION
    // ==========================================
    public void updateEvent(String title, String image, String date, String location, String description) {
        clearAndType(eventTitleField, title);
        clearAndType(eventImageField, image);
        clearAndType(eventDateField, date);
        clearAndType(eventLocationField, location);
        clearAndType(eventDescriptionField, description);

        click(updateEventButton);
        waitForAnimation();
    }

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickUpdateEventButton() {
        click(updateEventButton);
    }


    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getEventTitleLabelText() {
        return getText(eventTitleLabel);
    }

    public String getEventImageLabelText() {
        return getText(eventImageLabel);
    }

    public String getEventDateLabelText() {
        return getText(eventDateLabel);
    }

    public String getEventLocationLabelText() {
        return getText(eventLocationLabel);
    }

    public String getEventDescriptionLabelText() {
        return getText(eventDescriptionLabel);
    }

    public String getUpdateEventButtonText() {
        return getText(updateEventButton);
    }

    public String getUnexpectedApplicationErrorText() {
        return getText(unexpectedApplicationErrorTitle);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isUpdateEventButtonDisplayed() {
        return isDisplayed(updateEventButton);
    }

    // ==========================================
    // LABEL DEFAULT COLOR ACTIONS
    // ==========================================
    public String getEventTitleLabelDefaultColor() {
        return getElementColorAsRgba(eventTitleLabel, COLOR);
    }

    // ==========================================
    // FOCUS EFFECT ACTIONS
    // ==========================================
    public String getEventTitleLabelFocusedColor() {
        click(eventTitleField);
        waitForAnimation();

        return getElementColorAsHex(eventTitleLabel, COLOR);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getUpdateEventButtonHoverEffect() {
        hover(updateEventButton);
        waitForAnimation();

        return getElementColorAsHex(updateEventButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getUpdateEventButtonDefaultBackgroundColor() {
        return getElementColorAsHex(updateEventButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getUpdateEventButtonTextColor() {
        return getElementColorAsHex(updateEventButton, COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getEventTitleLabelTextFont() {
        return getFont(eventTitleLabel);
    }

    public String getEventTitleLabelTextFontSize() {
        return getFontSize(eventTitleLabel);
    }

    public String getUpdateEventButtonTextFont() {
        return getFont(updateEventButton);
    }

    public String getUpdateEventButtonTextFontSize() {
        return getFontSize(updateEventButton);
    }
}
