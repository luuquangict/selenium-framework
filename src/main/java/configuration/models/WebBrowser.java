package configuration.models;

public class WebBrowser {
    private String name;
    private String version;
    private String osPlatform;
    private boolean enable;

    public WebBrowser() {
    }

    public WebBrowser(String name) {
        this.name = name;
    }

    public WebBrowser(String name, String version, String osPlatform) {
        this.name = name;
        this.version = version;
        this.osPlatform = osPlatform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public OsPlatform getOsPlatform() {

        switch (this.osPlatform.toLowerCase()) {
            case "windows":
                return OsPlatform.Windows;

            case "linux":
                return OsPlatform.Linux;

            case "mac":
                return OsPlatform.Mac;

            default:
                return OsPlatform.Unknown;
        }
    }

    public void setOsPlatform(String osPlatform) {
        this.osPlatform = osPlatform;
    }

    public boolean isEnable() {
        return enable;
    }

    public WebBrowserType getType() {

        switch (name.toLowerCase()) {
            case "chrome":
                return WebBrowserType.Chrome;

            case "firefox":
                return WebBrowserType.Firefox;

            case "edge":
                return WebBrowserType.Edge;

            case "safari":
                return WebBrowserType.Safari;

            case "ie":
                return WebBrowserType.IE;

            default:
                return WebBrowserType.Unknown;
        }
    }

    public Object[] toObject() {
        return new Object[]{
                this.name,
                this.version,
                this.osPlatform
        };
    }

    @Override
    public String toString() {
        return "WebBrowser{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", osPlatform='" + osPlatform + '\'' +
                '}';
    }
}

