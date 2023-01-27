import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {
    public static WebDriver getBrowser() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
        } catch (RuntimeException e) {
            e.printStackTrace();
            browserName = "chrome";
        }
        if (browserName == null) browserName = "chrome";
        String path = System.getProperty("user.dir");
        switch (browserName) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver");
                return new ChromeDriver();
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/Yandex");
                return new ChromeDriver();
            }
            default: {
                System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver");
                throw new RuntimeException("В этом браузере не тестируем");
            }
        }
    }
}
