package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final static String TITLE = "Страница авторизации";

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.name("commit");

    public LoginPage(WebDriver driver) {
        super(driver, TITLE);
    }

    @Step("Входим в аккаунт GitHub")
    public MainPage login(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new MainPage(driver);
    }

    @Step("Проверяем поля логина")
    public LoginPage checkAuthFields() {
        Assert.assertTrue("Поле логин видимо", this.driver.findElement(loginField).isDisplayed());
        Assert.assertTrue("Поле пароль видимо", this.driver.findElement(passwordField).isDisplayed());
        Assert.assertTrue("Кнопка войти видимо", this.driver.findElement(signInButton).isDisplayed());
        return this;
    }
}
