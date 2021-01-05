package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private final static Logger LOG = LogManager.getLogger("Base Test");

    protected WebDriver driver;

    @Before
    public void SetUp() {
        switch (System.getProperty("browser", "chrome")){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
            case "ie":
                driver = new ChromeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
       // driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }

    @After
    public void tearDown() {
        LOG.info(driver.getCurrentUrl());
        driver.quit();
    }
}
