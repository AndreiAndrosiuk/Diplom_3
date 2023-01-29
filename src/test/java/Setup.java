import org.openqa.selenium.WebDriver;

public class Setup {
    protected WebDriver driver;

    public WebDriver driverSetUp() {
        driver = BrowserConfiguration.getBrowser();
        return driver;
    }
}
