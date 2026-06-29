package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    public static final String BASE_URL = "http://localhost:3000/";

    @BeforeEach
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigateToPage() {
        driver.get(BASE_URL);
    }

    public void navigateToPage(String relativePath) {
        driver.get(BASE_URL + relativePath);
    }

    @AfterEach
    public void tearDownBrowser() {
        driver.quit();
    }
}
