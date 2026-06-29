package base;

import pages.LoginPage;

public abstract class BaseAuthenticatedTest extends BaseTest {

    protected void loginPrerequisite() {
        LoginPage loginPage = new LoginPage(driver);

        navigateToPage("auth?mode=login");
        loginPage.login("testuser@email.com", "testuser123");
    }
}
