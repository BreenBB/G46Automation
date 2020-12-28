package tests.ui;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.issues.IssuesPage;
import tests.BaseTest;

import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readIssuesDataFromExcelFile;
import static helpers.FileHelper.readIssuesDataFromFile;

@RunWith(Parameterized.class)
public class HomeWork03Test extends BaseTest {
    private IssuesPage page;

    private String title;
    private String body;
    private List<String> labels;

    public HomeWork03Test(String title,
                          String body,
                          List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        if (System.getProperty("readfromExcel").equals("true")) {
            return readIssuesDataFromExcelFile(System.getProperty("user.dir")
                    + "/src/test/resources/data/issues.xlsx", "Sheet1");
        }
        else {
            return readIssuesDataFromFile(System.getProperty("user.dir")
             + "/src/test/resources/data/issues.txt");
        }
    }

    @Before
    public void signIn(){
        page = new LoginPage(driver)
                .login(System.getProperty("login"), System.getProperty("password"))
                .searchProject("G46Automation")
                .openProjectIssues();
    }

    @Owner("BreenBB")
    @Feature("")
    @Stories({@Story("Issue Creation"), @Story("GitHub")})
    @Link("G-46")
    @TmsLink("TC-3")
    @Description("Please ignore me!")
    @Severity(SeverityLevel.CRITICAL)
    @Ignore
    @Test
    public void checkIssueCreation(){
        page.pressToCreateNewIssue()
                .createNewIssue(this.title, this.body, this.labels)
                .validateCreatedIssue(this.title, this.body, this.labels);
    }

    @After
    public void tearDown() {
        page.logOut()
                .validateLogOut();
        driver.quit();
    }

}
