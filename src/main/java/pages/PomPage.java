package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PomPage extends BasePage {
    private final static String TITLE = "Страница файла pom.xml";

    private By seleniumVer = By.id("LC20");
    private By userIcon = By.cssSelector("[aria-label='View profile and more']");
    private By signOutButton = By.cssSelector("button[class='dropdown-item dropdown-signout']");

    public PomPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public PomPage getSeleniumVer() {
        String version = driver.findElement(seleniumVer).getText();
        String[] split = version.split("(?=<)|(?<=>)");
        log.info("Версия Selenium: " + split[2]);
        assertTrue(split[2].contains("3.141.59"));
        return this;
    }

    public PomPage checkSeleniumVer() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue("Текст версии Selenium видим", this.driver.findElement(seleniumVer).isDisplayed());
        return this;
    }

    public MainPage logOut() throws InterruptedException {
        driver.findElement(userIcon).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(signOutButton).click();
        return new MainPage(driver);
    }

    public MainPage logOut(int check) throws InterruptedException {
        assertTrue("Иконка пользователя видима", this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue("Текст SignOut видим", this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(signOutButton).click();
        return new MainPage(driver);
    }
}
