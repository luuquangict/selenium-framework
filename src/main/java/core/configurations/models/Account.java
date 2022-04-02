package core.configurations.models;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("type")
    public String type;

    @SerializedName("username")
    public String username;

    @SerializedName("password")
    public String password;
}
