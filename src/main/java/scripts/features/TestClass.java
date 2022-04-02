package scripts.features;

import core.configurations.models.WebBrowser;
import core.testng.annotations.Description;
import core.testng.annotations.Id;
import core.testng.annotations.Name;
import core.testng.annotations.Precondition;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import pageObjects.pages.PageTestLession7;
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
        pageTestLession7 = new PageTestLession7(webDriver, currentBrowser, this.pageCommon);
    }

    @Override
    protected void run() {
        System.out.println("Hello");
        pageTestLession7.clickOnButton1();
        pageTestLession7.verifyTextAfterClickButton1();
    }

    @Override
    protected void cleanUp() {
        // TODO: Clean up here
    }
}
