package configuration.loaders;

import configuration.models.Account;

public class AccountLoader extends BaseLoader<Account[]> {

    public AccountLoader(Class<Account[]> typeOfT) {
        super(typeOfT);
    }

    @Override
    protected String getFileName() {
        return "configuration/accounts.%s.json";
    }
}