import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import userinfo.UserInfo;

public class RedirectProfileTest extends  Setup {

    UserInfo userInfo = new UserInfo();

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
    @DisplayName("Переход на главную по клику на кнопку конструктора")
    public void clickToConstructorButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage.clickLoginButton();
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.clickProfileButton();
        profilePage.clickConstructorButton();
        mainPage.checkCreateBurgerDescription();
    }

    @Test
    @DisplayName("Переход на главную по клику на логотип в шапке сайта")
    public void clickToLogoTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage.clickLoginButton();
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.clickProfileButton();
        profilePage.clickLogoButton();
        mainPage.checkCreateBurgerDescription();
    }
}
