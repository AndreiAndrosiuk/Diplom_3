package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    public final String URL = "https://stellarburgers.nomoreparties.site";

    //Локатор хедера
    public final By header = By.xpath("//h1");

    //Локатор кнопки "Личный кабинет"
    public final By profileButton = By.xpath("//p[text()='Личный Кабинет']");

    //Локатор кнопки "Войти в аккаунт"
    public final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");

    //Локатор кнопки "Булки"
    public final By bunButton = By.xpath("//span[text()='Булки']");

    //Локатор заголовка "Булки"
    public final By bunHeader = By.xpath("//h2[text()='Булки']");

    //Локатор кнопки "Соусы"
    public final By sauceButton = By.xpath("//span[text()='Соусы']");

    //Локатор заголовка "Соусы"
    public final By sauceHeader = By.xpath("//h2[text()='Соусы']");

    //Локатор кнопки "Начинки"
    public final By fillingButton = By.xpath("//span[text()='Начинки']");

    //Локатор заголовка "Начинки"
    public final By fillingHeader = By.xpath("//h2[text()='Начинки']");

    //Локатор кнопки "Оформить заказ"
    public final By orderButton = By.xpath("//button[text()='Оформить заказ']");

    //Локатор описания конструктора "Собери бургер"
    public final By createBurgerDescription = By.xpath("//h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return URL;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    public MainPage checkClickableOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        return this;
    }

    public MainPage checkCreateBurgerDescription() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(createBurgerDescription));
        return this;
    }

    public MainPage checkBunSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(bunHeader));
        return this;
    }

    public MainPage checkSauceSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(sauceHeader));
        return this;
    }

    public MainPage checkFillingSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        return this;
    }

}
