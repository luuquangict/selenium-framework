package configuration.models;

import com.google.gson.annotations.SerializedName;

public class TimeSleep {

    @SerializedName("refresh")
    public int refreshTime;

    @SerializedName("default")
    public int defaultTime;

    @SerializedName("long")
    public int longTime;
}
