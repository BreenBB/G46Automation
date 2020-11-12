package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectG46Page extends BasePage {

    private By pomLink = By.cssSelector("a[title='pom.xml']");

    public ProjectG46Page(WebDriver driver) {
        super(driver);
    }

    public PomPage clickPomLink() {
        driver.findElement(pomLink).click();
        return new PomPage(driver);
    }

    public ProjectG46Page checkPomLink() {
        Assert.assertTrue("Ссылка pom.xml видима", this.driver.findElement(pomLink).isDisplayed());
        return this;
    }
}
