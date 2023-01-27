import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import userinfo.UserInfo;

import static org.junit.Assert.assertEquals;

public class LoginTest extends Setup{
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
    @DisplayName("Авторизация на главной странице")
    public void loginOnMainPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.clickLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }
    @Test
    @DisplayName("Авторизация через кнопку Личный кабинет")
    public void loginOnProfilePageTest(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.clickProfileButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }
    @Test
    @DisplayName("Авторизация через кнопку в форме регистрации")
    public void loginOnRegistrationPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage.clickLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();

    }
    @Test
    @DisplayName("Авторизация через кнопку Восстановления пароля")
    public void loginOnForgotPasswordPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        forgotPasswordPage.clickLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.checkClickableOrderButton();
    }

}
