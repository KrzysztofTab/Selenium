package page.objects.test;


import org.testng.annotations.Test;
import page.objects.driver.manager.DriverUtils;
import page.objects.pageObjects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static page.objects.navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

}