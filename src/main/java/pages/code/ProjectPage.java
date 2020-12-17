package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePageWithTabs;

public class ProjectPage extends BasePageWithTabs {
    private final static String TITLE = "Страница проекта G46 Automation";

    private By pomLink = By.cssSelector("a[title='pom.xml']");

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
}
