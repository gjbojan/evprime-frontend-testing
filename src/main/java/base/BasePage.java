package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final String BACKGROUND_COLOR = "background-color";
    protected final String COLOR = "color";
    protected final String BORDER_COLOR = "border-color";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private Actions getActions() {
        return new Actions(driver);
    }

    private WebElement getVisibleElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private List<WebElement> getVisibleElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void click(By locator) {
        getClickableElement(locator).click();
    }

    protected String getText(By locator) {
        return getVisibleElement(locator).getText();
    }

    protected void hover(By locator) {
        WebElement element = getVisibleElement(locator);
        getActions().moveToElement(element).perform();
    }

    protected String getElementColorAsRgba(By locator, String cssProperty) {
        WebElement element = getVisibleElement(locator);
        Color elementColor = Color.fromString(element.getCssValue(cssProperty));

        return elementColor.asRgba();
    }

    protected String getElementColorAsHex(By locator, String cssProperty) {
        WebElement element = getVisibleElement(locator);
        Color elementColor = Color.fromString(element.getCssValue(cssProperty));

        return elementColor.asHex();
    }

    protected String getElementColorAsRgb(By locator, String cssProperty) {
        WebElement element = getVisibleElement(locator);
        Color elementColor = Color.fromString(element.getCssValue(cssProperty));

        return elementColor.asRgb();
    }

    protected String getFont(By locator) {
        WebElement element = getVisibleElement(locator);
        return element.getCssValue("font-family");
    }

    protected String getFontSize(By locator) {
        WebElement element = getVisibleElement(locator);
        return element.getCssValue("font-size");
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void waitForAnimation() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected void type(By locator, String text) {
        WebElement element = getClickableElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.clear();
        element.sendKeys(text);
    }

    protected void clearAndType(By locator, String text) {
        WebElement element = getClickableElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    protected String getImage(By locator) {
        WebElement element = getVisibleElement(locator);
        return element.getAttribute("src");
    }

    protected int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }

    protected boolean areAllElementsNotEmpty(By locator) {
        List<WebElement> elements = getVisibleElements(locator);

        if(elements.isEmpty()) {
            return false;
        }

        for(int i=0; i<elements.size(); i++) {
            if(elements.get(i).getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    protected boolean areAllElementsDisplayed(By locator) {
        List<WebElement> elements = getVisibleElements(locator);

        if(elements.isEmpty()) {
            return false;
        }

        for(int i=0; i<elements.size(); i++) {
            if(!elements.get(i).isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
