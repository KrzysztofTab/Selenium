package page.objects.fish.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.objects.driver.manager.DriverManager;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;


    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginDisplayed() {
        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
        return isDisplayed;
    }

}