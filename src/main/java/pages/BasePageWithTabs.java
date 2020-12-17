package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;
import pages.issues.IssuesPage;

import static helpers.ColorPrinter.printMessageInColor;
import static helpers.ConsoleColors.*;

public abstract class BasePageWithTabs extends BaseAuthorizedPage {

    private By codeTab = By.cssSelector("span[data-content='Code']");
    private By issuesTab = By.cssSelector("span[data-content='Issues']");
    private By pullRequestsTab = By.cssSelector("span[data-content='Pull requests']");
    private By actionsTab = By.cssSelector("span[data-content='Actions']");
    private By projectsTab = By.cssSelector("span[data-content='Projects']");
    private By wikiTab = By.cssSelector("span[data-content='Wiki']");
    private By securityTab = By.cssSelector("span[data-content='Security']");
    private By insightsTab = By.cssSelector("span[data-content='Insights']");
    private By settingsTab = By.cssSelector("span[data-content='Settings']");

    public BasePageWithTabs(WebDriver driver, String title) {
        super(driver, title);
    }

    @Step("Вывод разноцветных названий вкладок в консоли")
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
        return new ProjectPage(driver);
    }

    @Step("Открываем код проекта")
    public ProjectPage openProjectCode(){
        try {
            driver.findElement(codeTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new ProjectPage(driver);
    }

    @Step("Открываем вкладку Issues")
    public IssuesPage openProjectIssues(){
        try {
            driver.findElement(issuesTab).click();
        } catch (NoSuchElementException n){
            Assert.fail(n.getMessage());
        }
        return new IssuesPage(driver);
    }
}
