package selenium.models;

public class Locator extends BaseLocator {

    public Locator(LocatorType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Locator byId(String value) {
        return new Locator(LocatorType.Id, value);
    }

    public static Locator byClassName(String value) {
        return new Locator(LocatorType.ClassName, value);
    }

    public static Locator byTagName(String value) {
        return new Locator(LocatorType.TagName, value);
    }

    public static Locator byName(String value) {
        return new Locator(LocatorType.Name, value);
    }

    public static Locator byCssSelector(String value) {
        return new Locator(LocatorType.CssSelector, value);
    }
}
