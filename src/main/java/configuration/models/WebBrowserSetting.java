package configuration.models;

import com.google.gson.annotations.SerializedName;
import configuration.WebBrowserLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebBrowserSetting {

    private static WebBrowserSetting instance;

    public static WebBrowserSetting getInstance() {
        if (instance == null) {
            WebBrowserLoader loader = new WebBrowserLoader();
            instance = loader.load();
        }

        return instance;
    }

    @SerializedName("windows")
    private List<WebBrowser> windows;

    @SerializedName("linux")
    private List<WebBrowser> linux;

    @SerializedName("mac")
    private List<WebBrowser> mac;

    public List<Object[]> getEnableWebBrowsers() {
        List<WebBrowser> browsers = new ArrayList<>();
        browsers.addAll(windows.stream().map(x -> {
            x.setOsPlatform("windows");
            return x;
        }).filter(x -> x.isEnable()).collect(Collectors.toList()));

        browsers.addAll(linux.stream().map(x -> {
            x.setOsPlatform("linux");
            return x;
        }).filter(x -> x.isEnable()).collect(Collectors.toList()));

        browsers.addAll(mac.stream().map(x -> {
            x.setOsPlatform("mac");
            return x;
        }).filter(x -> x.isEnable()).collect(Collectors.toList()));

        return browsers.stream().map(x -> x.toObject()).collect(Collectors.toList());
    }
}
