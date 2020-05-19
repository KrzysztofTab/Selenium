package page.objects.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.objects.driver.manager.DriverManager;
import page.objects.driver.manager.DriverUtils;


public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {

        DriverManager.disposeDriver();
    }

    void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

  /*void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } */
