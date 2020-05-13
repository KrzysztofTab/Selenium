package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    // strona początkowa

    // znajc Lokator do "Enter the Stone"
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        //słowa kluczowe "this", która zwraca nam obiekt naszej strony
        /*Dzięki umieszczeniu wywołania metody initElements() wewnątrz
         konstruktora za każdym razem, kiedy będziemy wywoływać nowy
         obiekt danej strony wszystkie webelementy zostaną zainicjalizowane.
         */
        PageFactory.initElements(driver, this);
    }

    // klikamy na "Enter the Stone"
    public void clickOnEnterStoreLink() {
        enterStoreLink.click();
    }

}