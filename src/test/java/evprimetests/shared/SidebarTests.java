package evprimetests.shared;

import base.BaseNoPasswordPopupTest;
import components.AddEventButton;
import components.Sidebar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SidebarTests extends BaseNoPasswordPopupTest {

    private Sidebar sidebar;
    private AddEventButton addEventButton;

    @BeforeEach
    public void setUpSidebar() {
        navigateToPage();
        sidebar = new Sidebar(driver);
        addEventButton = new AddEventButton(driver);
    }

    @Test
    public void functionalMenuButtonTest() {
        sidebar.openMenu();

        assertTrue(sidebar.isSidebarExpanded());
    }

    @Test
    public void functionalCloseButtonTest() {
        sidebar.openMenu();
        sidebar.closeMenu();

        assertFalse(sidebar.isSidebarExpanded());
    }

    @Test
    public void functionalHomeButtonTest() {
        navigateToPage("events");

        sidebar.clickHomeOption();
        assertEquals("http://localhost:3000/", driver.getCurrentUrl());
    }

    @Test
    public void functionalEventsButtonTest() {
        sidebar.clickEventsOption();

        assertEquals("http://localhost:3000/events", driver.getCurrentUrl());
    }

    @Test
    public void functionalContactButtonTest() {
        sidebar.clickContactOption();

        assertEquals("http://localhost:3000/contact", driver.getCurrentUrl());
    }

    @Test
    public void functionalLoginButtonTest() {
        sidebar.clickLoginOption();

        assertEquals("http://localhost:3000/auth?mode=login", driver.getCurrentUrl());
    }

    @Test
    public void functionalLogoutButtonTest() {
        loginPrerequisite();

        sidebar.clickLogoutOption();
        assertEquals("http://localhost:3000/", driver.getCurrentUrl());
        assertFalse(sidebar.isLogoutButtonDisplayed());
        assertTrue(sidebar.isLoginButtonDisplayed());
        assertFalse(addEventButton.isAddEventButtonDisplayed());
    }

    @Test
    public void sidebarNavigationTextBeforeLoginTest() {
        sidebar.openMenu();

        assertEquals("Home", sidebar.getHomeText());
        assertEquals("Events", sidebar.getEventsText());
        assertEquals("Contact", sidebar.getContactText());
        assertEquals("Login", sidebar.getLoginText());
    }

    @Test
    public void sidebarNavigationTextAfterLoginTest() {
        loginPrerequisite();
        sidebar.openMenu();

        assertEquals("Home", sidebar.getHomeText());
        assertEquals("Events", sidebar.getEventsText());
        assertEquals("Contact", sidebar.getContactText());
        assertEquals("Log out", sidebar.getLogoutText());
    }

    @Test
    public void sidebarFontValidationTest() {
        sidebar.openMenu();

        assertTrue(sidebar.getHomeOptionFont().contains("Josefin Sans"));
        assertEquals("16px", sidebar.getHomeOptionFontSize());
        assertTrue(sidebar.getEventsOptionFont().contains("Josefin Sans"));
        assertEquals("16px", sidebar.getEventsOptionFontSize());
        assertTrue(sidebar.getContactOptionFont().contains("Josefin Sans"));
        assertEquals("16px", sidebar.getContactOptionFontSize());
        assertTrue(sidebar.getLoginOptionFont().contains("Josefin Sans"));
        assertEquals("16px", sidebar.getLoginOptionFontSize());

        loginPrerequisite();

        sidebar.openMenu();
        assertTrue(sidebar.getLogoutOptionFont().contains("Josefin Sans"));
        assertEquals("16px", sidebar.getLogoutOptionFontSize());
    }

    @Test
    public void sidebarHoverEffectValidationTest() {
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getMenuButtonHoverEffect());

        sidebar.openMenu();
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getCloseButtonHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getHomeOptionHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getEventsOptionHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getContactOptionHoverEffect());
        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getLoginOptionHoverEffect());

        loginPrerequisite();

        assertEquals("rgba(0, 0, 0, 0.04)", sidebar.getLogoutOptionHoverEffect());
    }
}
