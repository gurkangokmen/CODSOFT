package atm;

import account.UserAccount;

import java.util.Scanner;

// 1.Create a class to represent the ATM machine.
// 7. Display appropriate messages to the user based on their chosen options and the success or failure of their transactions.
public class Atm {
    private UserAccount userAccount = new UserAccount();
    private String currentUser;

    public void login(String name) {
        if (userAccount.getUser(name) == null) {System.out.println("User not found.");}
        else {System.out.println("Welcome, " + name + "!"); currentUser = name;}
    }

    public void logout() {
        if (currentUser != null) {System.out.println("Goodbye, " + currentUser + "!"); currentUser = null;}
        else {throw new IllegalStateException("User not logged in.");}
    }

    public void run() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Please log in to continue.");

        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("name: ");
        currentUser = scanner.next();

        while (!input.equals("exit")) {
            System.out.println("Enter a command: (withdraw, deposit, checkBalance, exit)");
            input = scanner.next();
            switch (input) {
                case "withdraw":
                    System.out.println("Enter amount to withdraw: ");
                    withdraw(scanner.nextDouble());
                    break;
                case "deposit":
                    System.out.println("Enter amount to deposit: ");
                    deposit(scanner.nextDouble());
                    break;
                case "checkBalance":
                    System.out.println("Current balance: " + checkBalance());
                    break;
                case "exit":
                    logout();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }


    // 5. Connect the ATM class with the user's bank account class to access and modify the account balance.
    public void withdraw(double amount) {
        if (currentUser != null) {userAccount.getUser(currentUser).withdraw(amount);}
        else {throw new IllegalStateException("User not logged in.");}
    }

    public void deposit(double amount) {
        if (currentUser != null) {userAccount.getUser(currentUser).deposit(amount);}
        else {throw new IllegalStateException("User not logged in.");}
    }

    public double checkBalance() {
        if (currentUser != null) {return userAccount.getUser(currentUser).checkBalance();}
        else {throw new IllegalStateException("User not logged in.");}
    }


}
