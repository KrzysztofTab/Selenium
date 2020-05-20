package page.objects.driver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer"),
    EDGE("edge");


    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
