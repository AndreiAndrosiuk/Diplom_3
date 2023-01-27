import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import userinfo.UserInfo;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends Setup{

    UserInfo userInfo = new UserInfo();

   @Before
   public void begin() {
       driverSetUp();
       driver.manage().window().maximize();
    }
    @After
    public void teardown() {
        System.out.println("teardown");
        driver.close();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void SuccessRegisterTest()  {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register"); // перехожу на страницу регистрации
        registrationPage.setName(userInfo.nameForRegistration);//подставить userinfo
        registrationPage.setEmail(userInfo.emailForRegistration);
        registrationPage.setPassword(userInfo.passwordForRegistration);
        registrationPage.clickRegistrationButton();
        loginPage.checkClickableLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Pегистрация с некорректным паролем")
    public void IncorrectPasswordRegisterTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register"); // перехожу на страницу регистрации
        registrationPage.setName(userInfo.nameForRegistration);//подставить userinfo
        registrationPage.setEmail(userInfo.emailForRegistration);
        registrationPage.setPassword(userInfo.passwordForIncorrectRegistration);
        registrationPage.clickRegistrationButton();
        assertEquals(registrationPage.getUrl(), driver.getCurrentUrl());
        registrationPage.checkRegistrationError();
    }
}
