import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;

public class ConstructorTest extends Setup{

    @Before
    public void begin() {
        driverSetUp();
        driver.manage().window().maximize();
    }
    @After
    public void teardown() {
        driver.close();
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    public void checkBunSection(){
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.checkBunSection();
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    public void checkSauceSection(){
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.clickSauceButton();
        mainPage.checkSauceSection();
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void checkFillingSection(){
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.clickFillingButton();
        mainPage.checkFillingSection();
    }
}
