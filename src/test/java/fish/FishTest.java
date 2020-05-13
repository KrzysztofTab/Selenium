package fish;

import org.testng.annotations.Test;

public class FishTest extends TestBase {
    @Test
    public void angelFishTest() {
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }

    private void sleep() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
