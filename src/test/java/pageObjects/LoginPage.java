package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // @FindBy znajduje lokator elementu który bedziemy wywoływali
    // @FindBy znajduje lokator username
    @FindBy(name = "username")
    private WebElement usernameField;

    //@FindBy znajduje lokator password
    @FindBy(name = "password")
    private WebElement passwordField;

    //@FindBy znajduje lokator przysisku login
    @FindBy(name = "signon")
    private WebElement signOnButton;

    //@FindBy znajduje lokator baneru który się wyswetli
    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeIntoUserNameField(String username) {
        // wyczysc
        usernameField.clear();
        //wpisz username
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        //wyczysc
        passwordField.clear();
        //wpisz password
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        //kliknij na login
        signOnButton.click();
    }

    public String getWarningMessage() {
        // porównaj tekst
        String warningText = messageLabel.getText();
        return warningText;
    }

}
