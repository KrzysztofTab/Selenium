package page.objects.fishObjects;

import org.openqa.selenium.support.PageFactory;
import page.objects.driver.manager.DriverManager;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

}