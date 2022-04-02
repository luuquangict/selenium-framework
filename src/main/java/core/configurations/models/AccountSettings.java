package core.configurations.models;

import com.google.gson.annotations.SerializedName;
import core.configurations.AccountLoader;

public class AccountSettings {
    private static AccountSettings instance;

    public static AccountSettings getInstance() {
        if (instance == null) {
            AccountLoader loader = new AccountLoader();
            instance = loader.load();
        }

        return instance;
    }

    @SerializedName("default")
    private Account defaultAccount;

    @SerializedName("admin")
    private Account adminAccount;

    @SerializedName("invalid")
    private Account invalidAccount;

    public Account getDefaultAccount() {
        return defaultAccount;
    }

    public Account getAdminAccount() {
        return adminAccount;
    }

    public Account getInvalidAccount() {
        return invalidAccount;
    }
}
