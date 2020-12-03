package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private final static Logger LOG = LogManager.getLogger("Base Test");

    protected WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/drivers/chrome/v87/chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }

    @After
    public void tearDown() {
        LOG.info(driver.getCurrentUrl());
        driver.quit();
    }
}
