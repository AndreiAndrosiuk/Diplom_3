package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private static final String URL = "https://stellarburgers.nomoreparties.site";

    //Локатор хедера
    private final By header = By.xpath("//h1");

    //Локатор кнопки "Личный кабинет"
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");

    //Локатор кнопки "Войти в аккаунт"
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");

    //Локатор кнопки "Булки"
    private final By bunButton = By.xpath("//span[text()='Булки']");

    //Локатор заголовка "Булки"
    private final By bunHeader = By.xpath("//h2[text()='Булки']");

    //Локатор кнопки "Соусы"
    private final By sauceButton = By.xpath("//span[text()='Соусы']");

    //Локатор заголовка "Соусы"
    private final By sauceHeader = By.xpath("//h2[text()='Соусы']");

    //Локатор кнопки "Начинки"
    private final By fillingButton = By.xpath("//span[text()='Начинки']");

    //Локатор заголовка "Начинки"
    private final By fillingHeader = By.xpath("//h2[text()='Начинки']");

    //Локатор для активной секции
    private final By activeSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    //Локатор кнопки "Оформить заказ"
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");

    //Локатор описания конструктора "Собери бургер"
    private final By createBurgerDescription = By.xpath("//h1[text()='Соберите бургер']");

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

    public MainPage checkActiveBunSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(activeSection, "Булки"));
        return this;
    }

    public MainPage checkActiveSauceSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(activeSection, "Соусы"));
        return this;
    }

    public MainPage checkActiveFillingSection() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(activeSection, "Начинки"));
        return this;
    }
}
