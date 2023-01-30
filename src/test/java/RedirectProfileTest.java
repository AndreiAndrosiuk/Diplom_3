import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import userinfo.User;
import userinfo.UserClient;

import static config.Urls.LOGIN_PAGE_URL;

public class RedirectProfileTest extends Setup {

    User user = new User();
    UserClient userClient = new UserClient();
    ValidatableResponse response;
    String accessToken;

    @Before
    public void begin() {
        response = userClient.createUser(user);
        driverSetUp();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.close();
        accessToken = response.extract().body().path("accessToken");
        try {
            userClient.deleteUser(accessToken);
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: невозможно удалить пользователя.");
        }
    }

    @Test
    @DisplayName("Переход на главную по клику на кнопку конструктора")
    public void clickToConstructorButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get(LOGIN_PAGE_URL);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
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
        driver.get(LOGIN_PAGE_URL);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickProfileButton();
        profilePage.clickLogoButton();
        mainPage.checkCreateBurgerDescription();
    }
}
