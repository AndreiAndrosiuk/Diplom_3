import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

public class Setup {
    protected WebDriver driver;

    public  WebDriver driverSetUp() {
        driver = Configuration.getBrowser();
        return driver;
    }
}
