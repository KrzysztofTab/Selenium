package waitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTests2 extends BeforeAfterM {
    @Test
    public void fluentWaitWithExceptionTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");

        WebElement butonStart = driver.findElement(By.cssSelector("#start > button"));
        butonStart.click();
        sleep();

        driver.findElement(By.cssSelector("#finish > h4"));
        //Implementacje interfejsu Wait
        //Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        WebElement helloWorldMessage = fluentWait
                //określamy interwał, z jakim driver ma pytać przeglądarkę czy dany warunek został spełniony
                .pollingEvery(Duration.ofMillis(250))

                //określa po jakim czasie wyszukiwanie ma zostać przerwane,
                // jeśli do zadanego czasu warunek nie został spełniony
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                //until() – w metodzie tej ustawiamy, na jaki typ zdarzenia ma czekać driver.
                //Do typu zdarzenia wykorzystuje się klasę ExpectedConditions
                //visibilityOfElementLocated-sprawdza, czy element jest dostępny w DOM oraz widoczny
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));
        sleep();
        // czy wiyswietlono napis
        assertTrue(helloWorldMessage.isDisplayed());
    }
}
