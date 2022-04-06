package configuration.models;

import com.google.gson.annotations.SerializedName;
import configuration.AccountLoader;

public class AccountSetting {
    private static AccountSetting instance;

    public static AccountSetting getInstance() {
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
