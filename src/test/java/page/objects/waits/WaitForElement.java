package page.objects.waits;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.driver.manager.DriverManager;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {

        return new WebDriverWait(DriverManager.getWebDriver(), 10);
       // prywatną metodę getWebDriverWait(), która dostarcza nam instancję obiektu WebDriverWait z ustawionym timeout-em na 10 sekund.//
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element)); //WebElement będzie widoczny w DOM-ie
    } //WebElement będzie widoczny w DOM-ie

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)); //WebElement będzie klikalny
    } //czeka aż WebElement będzie klikalny

}
