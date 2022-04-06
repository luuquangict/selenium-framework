package scripts.features;

import configuration.models.WebBrowser;
import testng.annotations.Description;
import testng.annotations.Id;
import testng.annotations.Name;
import testng.annotations.Precondition;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Factory;
import scripts.base.TestScriptBase;

@Id(value = "FD-")
@Name(value = "")
@Description(value = "")
@Precondition(value = "")
public class TemplateScript extends TestScriptBase {
    @Factory(dataProvider = "dataProvider")
    public TemplateScript(String name, String version, String osPlatform) {
        super(name, version, osPlatform);
    }

    @Override
    protected void setup(WebDriver webDriver, WebBrowser currentBrowser) {
        // TODO: Precondition of test script
    }

    @Override
    protected void run() {
        // TODO: Body of test script
    }

    @Override
    protected void cleanUp() {
        // TODO: clean up after run test script
    }
}