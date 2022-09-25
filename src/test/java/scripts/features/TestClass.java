package scripts.features;

import configuration.models.Account;
import configuration.models.WebBrowser;
import testng.annotations.Description;
import testng.annotations.Id;
import testng.annotations.Name;
import testng.annotations.Precondition;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Factory;
import pageObjects.pages.PageTestLesson7;
import scripts.base.TestScriptBase;

@Id(value = "Fdev-001")
@Name(value = "TestClass")
@Description(value = "Create new category for system admin")
@Precondition(value = "Login into system")
public class TestClass extends TestScriptBase {
    @Factory(dataProvider = "dataProvider")
    public TestClass(String name, String version, String osPlatform) {
        super(name, version, osPlatform);
    }

    @Override
    protected void setup(WebDriver webDriver, WebBrowser currentBrowser) {
        pageTestLesson7 = new PageTestLesson7(webDriver, currentBrowser, this.pageCommon);
    }

    @Override
    protected void run() {
        Account account = accountManager.getAccount("quang");
        System.out.println(account.getUsername());

        pageTestLesson7.clickOnButton1();
        pageTestLesson7.verifyTextAfterClickButton1();
    }

    @Override
    protected void cleanUp() {
        // TODO: Clean up here
    }
}
