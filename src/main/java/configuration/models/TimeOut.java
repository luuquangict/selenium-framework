package configuration.models;

import com.google.gson.annotations.SerializedName;

public class TimeOut {
    @SerializedName("pageLoaded")
    public int pageLoaded;

    @SerializedName("findElement")
    public int findElement;
}
