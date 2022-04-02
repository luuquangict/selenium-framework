package pageObjects.constants.locators;

import core.selenium.models.Locator;
import core.selenium.models.XpathLocator;

public class PageCommonLocator {
    public static final XpathLocator locator1 = XpathLocator.create("YOUR_XPATH");
    public static final Locator locator2 = Locator.byId("YOUR_ID");

    public static final XpathLocator buttonByLabel = XpathLocator.create("//*[contains(@class, 'btn') and text() = '%s']");
}
