package evprimetests.authenticated;

import base.BaseNoPasswordPopupTest;
import components.AddEventButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEventButtonTests extends BaseNoPasswordPopupTest {

    private AddEventButton addEventButton;

    @BeforeEach
    public void setUpAddEventButton() {
        loginPrerequisite();
        addEventButton = new AddEventButton(driver);
    }

    @Test
    public void navigateToCreateEventPageTest() {
        addEventButton.clickCreateAnEventButton();

        assertEquals("http://localhost:3000/events/new", driver.getCurrentUrl());
    }

    @Test
    public void addEventNavigationHoverEffectsTest() {
        assertTrue(addEventButton.isAddEventButtonDisplayed());

        assertEquals("rgb(33, 55, 177)", addEventButton.getAddEventButtonHoverEffect());
        assertTrue(addEventButton.isCreateAnEventButtonDisplayed());

        addEventButton.hoverAddEventButton();
        assertEquals("rgb(216, 216, 216)", addEventButton.getCreateAnEventButtonHoverEffect());
        assertTrue(addEventButton.isCreateEventTooltipDisplayed());
        assertEquals("Create an event", addEventButton.getCreateEventButtonHoverText());
    }

    @Test
    public void createAnEventButtonTextFontAndFontSizeTest() {
        addEventButton.hoverAddEventButton();
        addEventButton.hoverCreateAnEventButton();

        assertTrue(addEventButton.getCreateEventButtonHoverTextFont().contains("Josefin Sans"));
        assertEquals("16px", addEventButton.getCreateEventButtonHoverTextFontSize());
    }
}
