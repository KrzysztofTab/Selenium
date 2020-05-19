package page.objects.driver.manager;

import org.openqa.selenium.WebDriver;
import page.objects.driver.BrowserFactory;
import page.objects.driver.BrowserType;

public class DriverManager {

    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME; //zmienimy przegladarkę CHROME; FIREFOX; IE
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
