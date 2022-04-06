package configuration.models;

import com.google.gson.annotations.SerializedName;

public class WebUrl {

    @SerializedName("url")
    public String url;

    @SerializedName("enable")
    public boolean enable;
}
