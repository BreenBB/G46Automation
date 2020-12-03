package pages.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PomPage extends BaseAuthorizedPage {
    private final static String TITLE = "Страница файла pom.xml";

    private By seleniumVer = By.id("LC20");

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
}
