package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEventButton extends BasePage {

    public AddEventButton (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By addEventButton = By.cssSelector("button[aria-label='SpeedDial']");
    private final By createEventButton = By.cssSelector("button[role='menuitem']");
    private final By createEventTooltip = By.xpath("//p[normalize-space()='Create an event']");

    // ==========================================
    // CLICK CREATE AN EVENT BUTTON
    // ==========================================
    public void clickCreateAnEventButton() {
        hover(addEventButton);
        waitForAnimation();

        click(createEventButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isAddEventButtonDisplayed() {
        return isDisplayed(addEventButton);
    }

    public boolean isCreateAnEventButtonDisplayed() {
        return isDisplayed(createEventButton);
    }

    public boolean isCreateEventTooltipDisplayed() {
        return isDisplayed(createEventTooltip);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getCreateEventButtonHoverText() {
        hover(createEventButton);

        return getText(createEventTooltip);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public void hoverAddEventButton() {
        hover(addEventButton);
    }

    public void hoverCreateAnEventButton() {
        hover(createEventButton);
    }

    public String getAddEventButtonHoverEffect() {
        hoverAddEventButton();
        waitForAnimation();

        return getElementColorAsRgb(addEventButton, BACKGROUND_COLOR);

    }

    public String getCreateAnEventButtonHoverEffect() {
        hoverCreateAnEventButton();
        waitForAnimation();

        return getElementColorAsRgb(createEventButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getCreateEventButtonHoverTextFont() {
        return getFont(createEventTooltip);
    }

    public String getCreateEventButtonHoverTextFontSize() {
        return getFontSize(createEventTooltip);
    }
}
