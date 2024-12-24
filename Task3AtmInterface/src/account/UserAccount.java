package account;

import user.UserImpl;

import java.util.HashMap;
import java.util.Map;

// 4. Create a class to represent the user's bank account, which stores the account balance.
public class UserAccount {
    private static Map<String, UserImpl> accounts = new HashMap<>();

    public void addUser(String name, double initialBalance) {
        accounts.put(name, new UserImpl(initialBalance));
        System.out.println("User " + name + " added.");
    }

    public UserImpl getUser(String name) { return accounts.get(name); }
}
