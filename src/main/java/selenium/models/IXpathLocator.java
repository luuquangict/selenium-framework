package selenium.models;

public interface IXpathLocator extends ILocator {
    XpathLocator addParams(Object... objects);
    XpathLocator add(IXpathLocator child);
    XpathLocator addParent(IXpathLocator parent);
    XpathLocator addIndex(int index);
}
