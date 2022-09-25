package configuration.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class AppSetting {

    @SerializedName("webUrl")
    private WebUrl[] webUrls;

    @SerializedName("timeSleep")
    private TimeSleep timeSleep;

    @SerializedName("timeOut")
    private TimeOut timeOut;

    @SerializedName("options")
    private Options options;

    public String getWebUrl() {
        WebUrl webUrl = Arrays.stream(this.webUrls).filter(x -> x.enable).findFirst().orElse(null);
        if (webUrl == null)
            throw new RuntimeException("Could not found any URL is enabled. Please check app setting file again");

        return webUrl.url;
    }

    public TimeSleep getTimeSleep() {
        return timeSleep;
    }

    public TimeOut getTimeOut() {
        return timeOut;
    }

    public Options getOptions() {
        return options;
    }
}
