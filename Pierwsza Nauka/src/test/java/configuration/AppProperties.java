package configuration;

// klasa będzie dostarczała właściwości związanych z aplikacją. Tutaj aktualnie mamy tylko jedną właściwość app.url

public class AppProperties {

    //Metoda zwraca property o nazwie app.url wywołując metodę getProperty, na obiekcie zwracanym przez
    // metodę getProperties z klasy ConfigurationProperties
    public static String getAllUrl() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }
}
