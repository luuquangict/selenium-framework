package scripts.base;

import core.testng.TestRunner;
import pageObjects.pages.PageTestLession7;

public abstract class TestScriptBase extends TestRunner {
    public TestScriptBase(String name, String version, String osPlatform) {
        super(name, version, osPlatform);
    }

    protected PageTestLession7 pageTestLession7;
}
