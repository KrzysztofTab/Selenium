import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginMyStore {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
                    // ImplcitWait działa tylko na metodę findElement() (czas na szukanie elementu, jednostka)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    //okno przeglądarki zostanie zmaksymalizowane
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @Test
    public void loginMyStore() {

            //Kliknięcie w link "Sign In"
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
           //Wpisanie w polu Email address wartośći "Email"
        driver.findElement(By.id("email")).sendKeys("k.Kris@oulook.com");
        sleep();
           //Wpisanie w polu Password wartości "Password"
        driver.findElement(By.id("passwd")).sendKeys("qwerty123");
        sleep();
          //Kliknięcie w przycisk Sing in
        driver.findElement(By.id("SubmitLogin")).click();
        sleep();
     }

    private void sleep() {
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

}

