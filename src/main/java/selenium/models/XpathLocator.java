package selenium.models;

public class XpathLocator extends BaseLocator implements IXpathLocator {

    private XpathLocator() {
        this.type = LocatorType.Xpath;
    }

    public XpathLocator(String value) {
        this.type = LocatorType.Xpath;
        this.value = value;
    }

    public XpathLocator addParams(Object... objects) {
        XpathLocator locator = this.cloneLocator();
        locator.value = String.format(locator.value, objects);
        return locator;
    }

    public XpathLocator add(IXpathLocator child) {
        XpathLocator locator = this.cloneLocator();
        locator.value += child.getValue();
        return locator;
    }

    public XpathLocator addParent(IXpathLocator parent) {
        XpathLocator locator = this.cloneLocator();
        locator.value = parent.getValue() + locator.value;
        return locator;
    }

    public XpathLocator addIndex(int index) {
        XpathLocator locator = this.cloneLocator();
        locator.value = String.format("(%s)[%d]", locator.value, index);
        return locator;
    }

    public XpathLocator normalizeSpace() {
        XpathLocator locator = this.cloneLocator();
        locator.value = locator.value.replace("text()", "normalize-space(text())");
        return locator;
    }

    public XpathLocator translate() {
        XpathLocator locator = this.cloneLocator();
        locator.value = locator.value.replace("text()", "translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')");
        return locator;
    }

    private XpathLocator cloneLocator() {
        XpathLocator locator = new XpathLocator();
        locator.value = this.value;
        return locator;
    }

    public static XpathLocator create(String value) {
        return new XpathLocator(value);
    }
}
