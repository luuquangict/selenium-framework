package configuration.models;

import com.google.gson.annotations.SerializedName;

public class Options {

    @SerializedName("quitDriver")
    public boolean quitDriver;

    @SerializedName("usingCache")
    public boolean usingCache;

    @SerializedName("writeLog")
    public boolean writeLog;
}
