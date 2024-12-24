import account.UserAccount;
import atm.Atm;

public class Main {
    public static void main(String[] args) {
        addUsers();

        Atm atm = new Atm();
        atm.run();
    }

    public static void addUsers() {
        UserAccount userAccount = new UserAccount();
        userAccount.addUser("Alice", 100);
        userAccount.addUser("Bob", 200);
        userAccount.addUser("Charlie", 300);
    }
}