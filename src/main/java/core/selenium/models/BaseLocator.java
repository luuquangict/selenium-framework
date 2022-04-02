package core.selenium.models;

import org.openqa.selenium.By;

public class BaseLocator implements ILocator {
    protected LocatorType type;
    protected String value;

    @Override
    public LocatorType getType() {
        return this.type;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public By getBy() {
        switch (this.type) {
            case Id:
                return By.id(this.value);
            case ClassName:
                return By.className(this.value);

            default:
                return By.xpath(this.value);
        }
    }
}
