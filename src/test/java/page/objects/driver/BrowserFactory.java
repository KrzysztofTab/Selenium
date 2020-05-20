package page.objects.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "C:/drivers/IEDriverServer.exe");
                return new InternetExplorerDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver", "C:/drivers/msedgedriver.exe");

            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}