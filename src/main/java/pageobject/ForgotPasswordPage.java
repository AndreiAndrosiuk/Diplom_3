package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    //Локатор для кнопки "Войти"
    private final By loginButton = By.xpath("//a[text()='Войти']");

    //Локатор для кнопки "Восстановить"
    private final By recoveryPasswordButton = By.xpath(".//button[text()= 'Восстановить']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
