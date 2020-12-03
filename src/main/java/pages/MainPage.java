package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseAuthorizedPage {
    private final static String TITLE = "Основная страница GitHub";

    private By projectLink = By.xpath("//aside[1]//*[@id=\"repos-container\"]/ul/li/div/a");
    private By logOutText = By.xpath("//h1[text() = 'Built for developers']");

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public ProjectPage clickProjectLink() {
        driver.findElement(projectLink).click();
        return new ProjectPage(driver);
    }

    public MainPage checkProjectLink() {
        Assert.assertTrue("Ссылка на проект видима", this.driver.findElement(projectLink).isDisplayed());
        return this;
    }

    public MainPage validateLogOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue("Текст при выходе из логина видим", this.driver.findElement(logOutText).isDisplayed());
        return this;
    }

}
