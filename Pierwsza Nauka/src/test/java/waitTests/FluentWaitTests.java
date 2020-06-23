package waitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FluentWaitTests extends BeforeAfterM {

    @Test
    public void fluentWaitTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
        // znajdż napis "Hello World!"
        WebElement helloWorldMessage = driver.findElement(By.cssSelector("#finish > h4"));

        // sprawdż czy jest niewidoczny
        assertFalse(helloWorldMessage.isDisplayed());
        sleep();

        // Naciśnij na przycisk Start
        WebElement butonStart = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        butonStart.click();
        sleep();

        //Implementacje interfejsu Wait
        //Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                //określamy interwał, z jakim driver ma pytać przeglądarkę czy dany warunek został spełniony
                .pollingEvery(Duration.ofMillis(250))

                //określa po jakim czasie wyszukiwanie ma zostać przerwane,
                // jeśli do zadanego czasu warunek nie został spełniony
                .withTimeout(Duration.ofSeconds(5))

                //until() – w metodzie tej ustawiamy, na jaki typ zdarzenia ma czekać driver.
                //Do typu zdarzenia wykorzystuje się klasę ExpectedConditions
                //invisibilityOf() – sprawdza czy element będzie niewidoczny (zniknie)
                .until(ExpectedConditions.visibilityOf(helloWorldMessage));
        sleep();
        // czy wiyswietlono napis
        assertTrue(helloWorldMessage.isDisplayed());
    }
}
