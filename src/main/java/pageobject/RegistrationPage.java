package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //Локатор для поля Имя
    private final By nameField = By.xpath(".//fieldset[1]//input");

    //Локатор для поля Email
    private final By emailField = By.xpath(".//fieldset[2]//input");

    //Локатор для поля Пароль
    private final By passwordField = By.xpath(".//fieldset[3]//input");

    //Локатор для кнопки "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    //Локатор для гиперссылки "Войти"
    private final By loginButtonLink = By.linkText("Войти");

    //Локатор для ошибки "Некорректный пароль"
    private final By errorPassword = By.xpath(".//div//p[text()= 'Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public String getUrl() {
        return URL;
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLink).click();
    }

    public RegistrationPage checkRegistrationError() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(errorPassword));
        return this;
    }

}
