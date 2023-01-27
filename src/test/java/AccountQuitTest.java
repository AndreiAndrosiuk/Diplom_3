import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import userinfo.UserInfo;

import static org.junit.Assert.assertEquals;

public class AccountQuitTest extends Setup{
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
    @DisplayName("Выход из аккаунта")
    public void accountExitTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage.setEmail(userInfo.emailForLogin);
        loginPage.setPassword(userInfo.passwordForLogin);
        loginPage.clickLoginButton();
        mainPage.clickProfileButton();
        profilePage.checkDescriptionProfilePage();
        profilePage.clickExitButton();
        loginPage.checkClickableLoginButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }
}
