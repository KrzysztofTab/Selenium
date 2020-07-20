import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Chrome {

    private WebDriver driver;

    @Given("Opening the browser")
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
                // ImplcitWait działa tylko na metodę findElement() (czas na szukanie elementu, jednostka)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //okno przeglądarki zostanie zmaksymalizowane
        driver.manage().window().maximize();
        driver.navigate().to("http://google.pl");
    }
    @When("Entering the searched page Filmweb")
    @Test
    public void myFirstTest() {

        driver.findElement(By.name("q")).sendKeys("Filmweb");
        driver.findElement(By.name("q")).submit();
        sleep();
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Filmweb"));

    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("Result and close")
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}