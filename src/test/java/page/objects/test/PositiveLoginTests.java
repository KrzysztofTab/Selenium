package page.objects.test;


import org.testng.annotations.Test;
import page.objects.driver.manager.DriverUtils;
import page.objects.pageObjects.LoginPage;

import static org.testng.Assert.assertTrue;
import static page.objects.navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        boolean isBannerAfterLoginDisplayed = loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }

}