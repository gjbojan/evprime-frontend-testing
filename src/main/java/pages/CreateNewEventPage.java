package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewEventPage extends BasePage {

    public CreateNewEventPage (WebDriver driver) {
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

    private final By createEventButton = By.cssSelector("button[type='submit']");

    private final By unexpectedApplicationErrorTitle = By.xpath("//h2[normalize-space()='Unexpected Application Error!']");

    // ==========================================
    // CREATION OF AN EVENT ACTION
    // ==========================================
    public void createEvent(String title, String image, String date, String location, String description) {
        if(!title.isBlank()) {
            type(eventTitleField, title);
        }

        if(!image.isBlank()) {
            type(eventImageField, image);
        }

        if(!date.isBlank()) {
            type(eventDateField, date);
        }

        if(!location.isBlank()) {
            type(eventLocationField, location);
        }

        if(!description.isBlank()) {
            type(eventDescriptionField, description);
        }

        click(createEventButton);
        waitForAnimation();
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

    public String getCreateEventButtonText() {
        return getText(createEventButton);
    }

    public String getUnexpectedApplicationErrorText() {
        return getText(unexpectedApplicationErrorTitle);
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
    public String getCreateEventButtonHoverEffect() {
        hover(createEventButton);
        waitForAnimation();

        return getElementColorAsRgb(createEventButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getCreateEventButtonDefaultBackgroundColor() {
        return getElementColorAsHex(createEventButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getCreateEventButtonTextColor() {
        return getElementColorAsHex(createEventButton, COLOR);
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

    public String getCreateEventButtonTextFont() {
        return getFont(createEventButton);
    }

    public String getCreateEventButtonTextFontSize() {
        return getFontSize(createEventButton);
    }
}
