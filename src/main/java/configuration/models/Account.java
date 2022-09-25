package configuration.models;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}