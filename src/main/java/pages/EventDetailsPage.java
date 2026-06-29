package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventDetailsPage extends BasePage {

    public EventDetailsPage (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By eventTitle = By.cssSelector("h2");
    private final By eventDate = By.xpath("//*[name()='svg' and @data-testid='CalendarMonthIcon']/following::h6[1]");
    private final By eventLocation = By.xpath("//*[name()='svg' and @data-testid='PlaceIcon']/following::h6[1]");
    private final By eventImage = By.xpath("//h2/ancestor::div[contains(@class,'MuiBox-root')]/following::img[1]");
    private final By eventDescription = By.xpath("//img/parent::div/following-sibling::span[1]");

    private final By deleteEventButton = By.xpath("//button[normalize-space()='Delete event']");
    private final By confirmDeleteButton = By.xpath("//button[normalize-space()='Delete']");
    private final By cancelDeleteButton = By.xpath("//button[normalize-space()='No']");
    private final By deleteConfirmationPopup = By.xpath("//h5[text()='Are you sure you want to delete this event?']");

    private final By editEventButton = By.xpath("//button[normalize-space()='Edit event']");
    private final By backToEventsButton = By.xpath("//button[normalize-space()='Back to events']");

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void clickDeleteEventButton() {
        click(deleteEventButton);
    }

    public void clickEditEventButton() {
        click(editEventButton);
    }

    public void clickBackToEventsButton() {
        click(backToEventsButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getEventTitleText() {
        return getText(eventTitle);
    }

    public String getEventDateText() {
        return getText(eventDate);
    }

    public String getEventLocationText() {
        return getText(eventLocation);
    }

    public String getEventDescriptionText() {
        return getText(eventDescription);
    }

    public String getDeleteEventButtonText() {
        return getText(deleteEventButton);
    }

    public String getEditEventButtonText() {
        return getText(editEventButton);
    }

    public String getBackToEventsButtonText() {
        return getText(backToEventsButton);
    }

    public String getDeleteEventPopupTitleText() {
        return getText(deleteConfirmationPopup);
    }

    public String getDeleteEventPopupDeleteOptionText() {
        return getText(confirmDeleteButton);
    }

    public String getDeleteEventPopupNoOptionText() {
        return getText(cancelDeleteButton);
    }

    // ==========================================
    // GET IMAGE ACTIONS
    // ==========================================
    public String getEventImage() {
        waitForAnimation();

        return getImage(eventImage);
    }

    // ==========================================
    // DELETE EVENT ACTIONS
    // ==========================================
    public void deleteAnEventDeleteOption() {
        clickDeleteEventButton();
        waitForAnimation();

        click(confirmDeleteButton);
    }

    public void deleteAnEventNoOption() {
        clickDeleteEventButton();
        waitForAnimation();

        click(cancelDeleteButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isDeleteButtonDisplayed() {
        waitForAnimation();
        return isDisplayed(deleteEventButton);
    }

    public boolean isDeletePopupDisplayed() {
        return isDisplayed(deleteConfirmationPopup);
    }

    public boolean isEventTitleDisplayed() {
        return isDisplayed(eventTitle);
    }

    public boolean isEventDateDisplayed() {
        return isDisplayed(eventDate);
    }

    public boolean isEventLocationDisplayed() {
        return isDisplayed(eventLocation);
    }

    public boolean isEventDescriptionDisplayed() {
        return isDisplayed(eventDescription);
    }

    public boolean isEventImageDisplayed() {
        return isDisplayed(eventImage);
    }

    // ==========================================
    // OPEN POPUP HELPER
    // ==========================================
    public void openDeletePopup() {
        clickDeleteEventButton();
    }

    // ==========================================
    // BUTTON DEFAULT COLOR ACTIONS
    // ==========================================
    public String getDeleteEventButtonDefaultBackgroundColor() {
        return getElementColorAsHex(deleteEventButton, BACKGROUND_COLOR);
    }

    public String getEditEventButtonDefaultBackgroundColor() {
        return getElementColorAsHex(editEventButton, BACKGROUND_COLOR);
    }

    public String getBackToEventsButtonDefaultBackgroundColor() {
        return getElementColorAsHex(backToEventsButton, BACKGROUND_COLOR);
    }

    public String getDeleteEventPopupDeleteButtonDefaultBackgroundColor() {
        return getElementColorAsHex(confirmDeleteButton, BACKGROUND_COLOR);
    }

    public String getDeleteEventPopupNoButtonDefaultBackgroundColor() {
        return getElementColorAsHex(cancelDeleteButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // BUTTON TEXT COLOR ACTIONS
    // ==========================================
    public String getDeleteEventButtonTextColor() {
        return getElementColorAsHex(deleteEventButton, COLOR);
    }

    public String getEditEventButtonTextColor() {
        return getElementColorAsHex(editEventButton, COLOR);
    }

    public String getBackToEventsButtonTextColor() {
        return getElementColorAsHex(backToEventsButton, COLOR);
    }

    public String getDeleteEventPopupDeleteButtonTextColor() {
        return getElementColorAsHex(confirmDeleteButton, COLOR);
    }

    public String getDeleteEventPopupNoButtonTextColor() {
        return getElementColorAsHex(cancelDeleteButton, COLOR);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getDeleteEventButtonHoverEffect() {
        hover(deleteEventButton);
        waitForAnimation();

        return getElementColorAsHex(deleteEventButton, BACKGROUND_COLOR);
    }

    public String getEditEventButtonHoverEffect() {
        hover(editEventButton);
        waitForAnimation();

        return getElementColorAsRgb(editEventButton, BACKGROUND_COLOR);
    }

    public String getBackToEventsButtonHoverEffect() {
        hover(backToEventsButton);
        waitForAnimation();

        return getElementColorAsHex(backToEventsButton, BACKGROUND_COLOR);
    }

    public String getDeleteEventPopupDeleteButtonHoverEffect() {
        hover(confirmDeleteButton);
        waitForAnimation();

        return getElementColorAsHex(confirmDeleteButton, BACKGROUND_COLOR);
    }

    public String getDeleteEventPopupNoButtonHoverEffect() {
        hover(cancelDeleteButton);
        waitForAnimation();
        waitForAnimation();

        return getElementColorAsHex(cancelDeleteButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getEventTitleFont() {
        return getFont(eventTitle);
    }

    public String getEventTitleFontSize() {
        return getFontSize(eventTitle);
    }

    public String getEventDateFont() {
        return getFont(eventDate);
    }

    public String getEventDateFontSize() {
        return getFontSize(eventDate);
    }

    public String getEventLocationFont() {
        return getFont(eventLocation);
    }

    public String getEventLocationFontSize() {
        return getFontSize(eventLocation);
    }

    public String getEventDescriptionFont() {
        return getFont(eventDescription);
    }

    public String getEventDescriptionFontSize() {
        return getFontSize(eventDescription);
    }

    public String getDeleteEventButtonTextFont() {
        return getFont(deleteEventButton);
    }

    public String getDeleteEventButtonTextFontSize() {
        return getFontSize(deleteEventButton);
    }

    public String getEditEventButtonTextFont() {
        return getFont(editEventButton);
    }

    public String getEditEventButtonTextFontSize() {
        return getFontSize(editEventButton);
    }

    public String getBackToEventsButtonTextFont() {
        return getFont(backToEventsButton);
    }

    public String getBackToEventsButtonTextFontSize() {
        return getFontSize(backToEventsButton);
    }

    public String getDeleteEventPopupTitleTextFont() {
        return getFont(deleteConfirmationPopup);
    }

    public String getDeleteEventPopupTitleTextFontSize() {
        return getFontSize(deleteConfirmationPopup);
    }

    public String getDeleteEventPopupDeleteButtonTextFont() {
        return getFont(confirmDeleteButton);
    }

    public String getDeleteEventPopupDeleteButtonTextFontSize() {
        return getFontSize(confirmDeleteButton);
    }

    public String getDeleteEventPopupNoButtonTextFont() {
        return getFont(cancelDeleteButton);
    }

    public String getDeleteEventPopupNoButtonTextFontSize() {
        return getFontSize(cancelDeleteButton);
    }
}
