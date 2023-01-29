package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Локатор для поля Email
    private final By emailField = By.xpath(".//fieldset[1]//input");

    //Локатор для поля Пароль
    private final By passwordField = By.xpath(".//fieldset[2]//input");

    //Локатор для кнопки "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    //Локатор для гиперссылки "Зарегистрироваться"
    private final By registrationLink = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage checkClickableLoginButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}
