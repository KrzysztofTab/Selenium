package pageObjects;

import fish.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        //Ustawienie ścieżki do WebDrivera Chrome
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        //Inicliazjacja ChromeDriver
        driver = new ChromeDriver();

        //Ustawienie Implicit Wait na 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Przejśćie do strony sklepu
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        //Kliknięcie w link "Enter the Store"
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        //Kliknięcie w link "Sign In"
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        //Wpisanie w polu Username wartośći "***"
        loginPage.typeIntoUserNameField("j2ee");
        sleep();
        //Wpisanie w polu Password wartości "***"
        loginPage.typeIntoPasswordField("j2ee");
        sleep();
        //Kliknięcie w przycisk Login
        loginPage.clickOnLoginButton();

        //Sprawdzenie czy na stronie pojawił się komunikat "Invalid username or password. Signon failed."
        // przez sprawdzenie jaki tekst wyświetli się w elemencie
        FooterPage footerPage = new FooterPage(driver);
        sleep();
        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }

    private void sleep() {
        // metoda zaczymujaca czas do podgladu testu nigdy się jej nie stosuje przy testowaniu
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        //Zamknięcie okna przeglądarki
        driver.close();
        //Wyłaczenie procesu WebDrivera
        driver.quit();
    }
}
