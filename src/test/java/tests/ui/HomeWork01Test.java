package tests.ui;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;
import tests.BaseTest;

public class HomeWork01Test extends BaseTest {
    private LoginPage page;

    @Before
    public void setPage(){
        this.page = new LoginPage(driver);
    }

    @Owner("BreenBB")
    @Feature("")
    @Stories({@Story("Write Selenium from pom.xml"), @Story("GitHub")})
    @Link("G-46")
    @TmsLink("TC-1")
    @Description("Please ignore me!")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testSeleniumVersion() throws InterruptedException {
        try{
            page.checkAuthFields()
                    .login(System.getProperty("login"), System.getProperty("password"))
                    .checkProjectLink()
                    .clickProjectLink()
                    .checkPomLink()
                    .clickPomLink()
                    .checkSeleniumVer()
                    .getSeleniumVer()
                    //.checkSignOut()
                    .logOut()
                    .validateLogOut();
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }
}
