package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;

public class HomWorld02Test extends BaseTest {
    private LoginPage page;

    @Before
    public void setPage(){
        this.page = new LoginPage(driver);
    }

    @Test
    public void testPrintColoredTabs() throws InterruptedException {
        try{
            page.checkAuthFields()
                    .login("login", "password")
                    .checkProjectLink()
                    .clickProjectLink()
                    .printColoredTabs()
                    .logOut(1)
                    .checkLogOutText();
        } catch (NoSuchElementException e){
            Assert.fail(e.getMessage());
        }
    }
}
