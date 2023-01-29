import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import userinfo.User;
import userinfo.UserClient;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends Setup {

    User user = new User();
    UserClient userClient;
    ValidatableResponse response;
    String accessToken;


    @Before
    public void begin() {
        userClient = new UserClient();
        driverSetUp();
        driver.manage().window().maximize();

    }

    @After
    public void teardown() {
        driver.close();
        response = userClient.login(user);
        accessToken = response.extract().body().path("accessToken");
        try {
            userClient.deleteUser(accessToken);
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: невозможно удалить пользователя.");
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void SuccessRegisterTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword(user.getPassword());
        registrationPage.clickRegistrationButton();
        loginPage.checkClickableLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Pегистрация с некорректным паролем")
    public void IncorrectPasswordRegisterTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword(RandomStringUtils.randomAlphabetic(5));
        registrationPage.clickRegistrationButton();
        assertEquals(registrationPage.getUrl(), driver.getCurrentUrl());
        registrationPage.checkRegistrationError();
    }
}
