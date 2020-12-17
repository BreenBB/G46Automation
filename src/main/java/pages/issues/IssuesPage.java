package pages.issues;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePageWithTabs;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class IssuesPage extends BasePageWithTabs {

    private final static String TITLE = "Страница со список задач проекта";

    public IssuesPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By newIssueButton = By.xpath("//a[@class = 'btn btn-primary']");

    @Step("Нажимем на кнопку создания Issue")
    public IssueCreationPage pressToCreateNewIssue(){
        log.info("Нажимем на \"Создать новую задачу\"");
        webDriverWait_10.until(elementToBeClickable(newIssueButton));
        Assert.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        driver.findElement(newIssueButton).click();
        log.info("Кнопка нажата");
        return new IssueCreationPage(driver);
    }
}