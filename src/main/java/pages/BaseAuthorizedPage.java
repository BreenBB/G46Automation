package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.ProjectPage;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public abstract class BaseAuthorizedPage extends BasePage{

    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }
    //Search field
    private final By searchField = By.xpath("//input[@data-unscoped-placeholder = 'Search or jump to…']");
    private final By searchResults = By.xpath("//li[contains(@id, 'jump-to-suggestion-')]");
    //User Buttons
    private final By userProfileButton = By.xpath("//summary[@aria-label = 'View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public ProjectPage searchProject (String projectName){
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        webDriverWait_10.until(numberOfElementsToBeMoreThan(searchResults, 1));
        driver.findElements(searchResults).get(1).click();
        return new ProjectPage(driver);
    }

    public MainPage logOut(){
        driver.findElement(userProfileButton).click();
        webDriverWait_10.until(elementToBeClickable(signOutButton));
        driver.findElement(signOutButton).click();
        return new MainPage(driver);
    }

}