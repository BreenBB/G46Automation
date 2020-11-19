package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static helpers.ColorPrinter.printMessageInColor;
import static helpers.ConsoleColors.*;
import static org.junit.Assert.assertTrue;

public class ProjectPage extends BasePage {
    private final static String TITLE = "Страница проекта G46 Automation";

    private By pomLink = By.cssSelector("a[title='pom.xml']");

    private By userIcon = By.cssSelector("[aria-label='View profile and more']");
    private By signOutButton = By.cssSelector("button[class='dropdown-item dropdown-signout']");

    private By codeTab = By.cssSelector("span[data-content='Code']");
    private By issuesTab = By.cssSelector("span[data-content='Issues']");
    private By pullRequestsTab = By.cssSelector("span[data-content='Pull requests']");
    private By actionsTab = By.cssSelector("span[data-content='Actions']");
    private By projectsTab = By.cssSelector("span[data-content='Projects']");
    private By wikiTab = By.cssSelector("span[data-content='Wiki']");
    private By securityTab = By.cssSelector("span[data-content='Security']");
    private By insightsTab = By.cssSelector("span[data-content='Insights']");
    private By settingsTab = By.cssSelector("span[data-content='Settings']");

    public ProjectPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public PomPage clickPomLink() {
        driver.findElement(pomLink).click();
        return new PomPage(driver);
    }

    public ProjectPage checkPomLink() {
        Assert.assertTrue("Ссылка pom.xml видима", this.driver.findElement(pomLink).isDisplayed());
        return this;
    }

    public ProjectPage printColoredTabs(){
        printMessageInColor(driver.findElement(codeTab).getText(), CYAN, log);
        printMessageInColor(driver.findElement(issuesTab).getText(), YELLOW, log);
        printMessageInColor(driver.findElement(pullRequestsTab).getText(), GREEN, log);
        printMessageInColor(driver.findElement(actionsTab).getText(), PURPLE, log);
        printMessageInColor(driver.findElement(projectsTab).getText(), WHITE, log);
        printMessageInColor(driver.findElement(wikiTab).getText(), BLUE, log);
        printMessageInColor(driver.findElement(securityTab).getAttribute("data-content"), CYAN, log);
        printMessageInColor(driver.findElement(insightsTab).getAttribute("data-content"), YELLOW, log);
        printMessageInColor(driver.findElement(settingsTab).getAttribute("data-content"), GREEN, log);
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

    public ProjectPage checkSignOut() throws InterruptedException {
        assertTrue("Иконка пользователя видима", this.driver.findElement(userIcon).isDisplayed());
        driver.findElement(userIcon).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue("Текст SignOut видим", this.driver.findElement(signOutButton).isDisplayed());
        driver.findElement(userIcon).click();
        return this;
    }
}
