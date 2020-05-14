package fish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");

    }

    void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    public static class FishTest extends TestBase {

        @Test
        public void angelFishTest() {


            driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");

            //Kliknięcie w link "Enter the Store"
            driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
            sleep();

            //Kliknięcie w link "Fish"
            driver.findElement(By.cssSelector("#MainImageContent > map > area:nth-child(2)")).click();
            sleep();

            //Kliknij w ID rybki Angel Fish
            driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(1) > a")).click();
            sleep();

            //Dodaj Small Angelfish do koszyka.
            driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
            sleep();

            //Kliknij w przycisk Proceed to checkout
            driver.findElement(By.xpath("//*[@id=\"Cart\"]/a")).click();
            sleep();

            //Sprawdzenie czy na stronie pojawił się komunikat "You must sign on before attempting to check out."
            // przez sprawdzenie jaki tekst wyświetli się w elemencie
            assertEquals(driver.findElement(By.cssSelector("#Content > ul > li")).getText(),
                    "You must sign on before attempting to check out. Please sign on and try checking out again.");
            sleep();
        }
    }
}
