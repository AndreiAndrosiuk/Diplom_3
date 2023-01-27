package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    public final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //Локатор кнопки "Выход"
    public final By exitButton = By.xpath("//button[text()='Выход']");

    //Локатор кнопки "Конструктор"
    public final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    //Локатор лого в шапке сайта
    public final By logo = By.className("AppHeader_header__logo__2D0X2");

    //Локатор описания страницы профиля
    public final By descriptionProfilePage = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage checkDescriptionProfilePage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(descriptionProfilePage));
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogoButton() {
        driver.findElement(logo).click();
    }

}
