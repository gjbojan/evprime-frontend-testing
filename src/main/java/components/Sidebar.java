package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sidebar extends BasePage {

    public Sidebar (WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private final By menuButton = By.cssSelector("button[aria-label='open drawer']");
    private final By closeButton = By.xpath("//*[@data-testid='ChevronLeftIcon']/ancestor::button");
    private final By homeButton = By.xpath("//span[text()='Home']/ancestor::div[@role='button']");
    private final By eventsButton = By.xpath("//span[text()='Events']/ancestor::div[@role='button']");
    private final By contactButton = By.xpath("//span[text()='Contact']/ancestor::div[@role='button']");
    private final By loginButton = By.xpath("//span[text()='Login']/ancestor::div[@role='button']");
    private final By logoutButton = By.xpath("//span[text()='Log out']/ancestor::div[@role='button']");

    private final By homeText = By.xpath("//span[text()='Home']");
    private final By eventsText = By.xpath("//span[text()='Events']");
    private final By contactText = By.xpath("//span[text()='Contact']");
    private final By loginText = By.xpath("//span[text()='Login']");
    private final By logoutText = By.xpath("//span[text()='Log out']");

    // ==========================================
    // CLICK ACTIONS
    // ==========================================
    public void openMenu() {
        click(menuButton);
        waitForAnimation();
    }

    public void closeMenu() {
        click(closeButton);
        waitForAnimation();
    }

    public void clickHomeOption() {
        click(homeButton);
    }

    public void clickEventsOption() {
        click(eventsButton);
    }

    public void clickContactOption() {
        click(contactButton);
    }

    public void clickLoginOption() {
        click(loginButton);
    }

    public void clickLogoutOption() {
        click(logoutButton);
    }

    // ==========================================
    // STATE VERIFICATIONS / VISIBILITY ACTIONS
    // ==========================================
    public boolean isSidebarExpanded() {
        return isDisplayed(eventsText);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(logoutButton);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    // ==========================================
    // GET TEXT ACTIONS
    // ==========================================
    public String getHomeText() {
        return getText(homeText);
    }

    public String getEventsText() {
        return getText(eventsText);
    }

    public String getContactText() {
        return getText(contactText);
    }

    public String getLoginText() {
        return getText(loginText);
    }

    public String getLogoutText() {
        return getText(logoutText);
    }

    // ==========================================
    // HOVER ACTIONS
    // ==========================================
    public String getMenuButtonHoverEffect() {
        hover(menuButton);

        return getElementColorAsRgba(menuButton, BACKGROUND_COLOR);
    }

    public String getCloseButtonHoverEffect() {
        hover(closeButton);

        return getElementColorAsRgba(closeButton, BACKGROUND_COLOR);
    }

    public String getHomeOptionHoverEffect() {
        hover(homeButton);

        return getElementColorAsRgba(homeButton, BACKGROUND_COLOR);
    }

    public String getEventsOptionHoverEffect() {
        hover(eventsButton);

        return getElementColorAsRgba(eventsButton, BACKGROUND_COLOR);
    }

    public String getContactOptionHoverEffect() {
        hover(contactButton);

        return getElementColorAsRgba(contactButton, BACKGROUND_COLOR);
    }

    public String getLoginOptionHoverEffect() {
        hover(loginButton);

        return getElementColorAsRgba(loginButton, BACKGROUND_COLOR);
    }

    public String getLogoutOptionHoverEffect() {
        hover(logoutButton);

        return getElementColorAsRgba(logoutButton, BACKGROUND_COLOR);
    }

    // ==========================================
    // FONT AND FONT SIZE ACTIONS
    // ==========================================
    public String getHomeOptionFont() {
        return getFont(homeText);
    }

    public String getHomeOptionFontSize() {
        return getFontSize(homeText);
    }

    public String getEventsOptionFont() {
        return getFont(eventsText);
    }

    public String getEventsOptionFontSize() {
        return getFontSize(eventsText);
    }

    public String getContactOptionFont() {
        return getFont(contactText);
    }

    public String getContactOptionFontSize() {
        return getFontSize(contactText);
    }

    public String getLoginOptionFont() {
        return getFont(loginText);
    }

    public String getLoginOptionFontSize() {
        return getFontSize(loginText);
    }

    public String getLogoutOptionFont() {
        return getFont(logoutText);
    }

    public String getLogoutOptionFontSize() {
        return getFontSize(logoutText);
    }
}
