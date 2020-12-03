package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;

public class HomeWork01Test extends BaseTest {
    private LoginPage page;

    @Before
    public void setPage(){
        this.page = new LoginPage(driver);
    }

    @Test
    public void testSeleniumVersion() throws InterruptedException {
        try{
            page.checkAuthFields()
                    .login("BreenBB", "UjhltyrjF7be5e")
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
