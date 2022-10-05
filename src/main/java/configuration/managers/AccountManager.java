package configuration.managers;

import configuration.loaders.AccountLoader;
import configuration.models.Account;
import org.openqa.selenium.NotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AccountManager {
    private static AccountManager instance;

    public static AccountManager getInstance() {
        if (instance == null) {
            AccountLoader loader = new AccountLoader(Account[].class);
            instance = new AccountManager();
            instance.accounts = loader.load();
        }

        return instance;
    }

    /**
     * Prevent user create new instance
     */
    private AccountManager() {
    }

    private Account[] accounts;

    public Account getDefaultAccount() {
        return getAccount("default");
    }

    public Account getAdminAccount() {
        return getAccount("admin");
    }

    public Account getUserAccount() {
        return getAccount("user");
    }

    public Account getInvalidAccount() {
        return getAccount("invalid");
    }

    public Account getAccount(String name) {
        List<Account> accounts = Arrays.asList(this.accounts).stream()
                .filter(x -> x.getName().trim().equalsIgnoreCase(name.trim()))
                .collect(Collectors.toList());

        if (accounts.size() == 0) {
            System.out.println("Could not found account with name: " + name);
            return null;
        }

        return accounts.get(0);
    }
}
