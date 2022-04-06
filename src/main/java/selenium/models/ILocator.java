package selenium.models;

import org.openqa.selenium.By;

public interface ILocator {
    By getBy();

    String getValue();

    LocatorType getType();
}
