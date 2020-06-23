package waitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExplicitWaitTests extends BeforeAfterM {

    @Test
    public void waitForDisappearingElement() {

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");

        // znajdz checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // sprawdź czy jest odznaczony
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        // cliknij w button " Remowe"
        WebElement removeButton = driver.findElement(By.id("btn"));
        removeButton.click();

        //Sprawdź, że po jakimś czasie pojawi się tekst
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        // Sprawdź,tekst "It's gone!"
        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");
    }
}


