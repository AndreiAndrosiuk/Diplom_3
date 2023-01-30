import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import userinfo.User;
import userinfo.UserClient;

import static config.Urls.*;
import static org.junit.Assert.assertEquals;

public class LoginTest extends Setup {

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
    @DisplayName("Авторизация на главной странице")
    public void loginOnMainPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.clickLoginButton();
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }

    @Test
    @DisplayName("Авторизация через кнопку Личный кабинет")
    public void loginOnProfilePageTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.clickProfileButton();
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме регистрации")
    public void loginOnRegistrationPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get(REGISTRATION_PAGE_URL);
        registrationPage.clickLoginButton();
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();

    }

    @Test
    @DisplayName("Авторизация через кнопку Восстановления пароля")
    public void loginOnForgotPasswordPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        forgotPasswordPage.clickLoginButton();
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }

}
