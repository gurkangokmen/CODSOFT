package user;

import exceptions.InsufficientFunds;
import exceptions.InvalidAmount;

// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
public class UserImpl implements User{
    public UserImpl(double initialBalance) {this.balance = initialBalance;}
    public UserImpl() {this.balance = 0;}

    private double balance;

    // 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) { throw new InvalidAmount("Invalid amount.");}
        else if (amount > balance) { throw new InsufficientFunds("Insufficient funds.");}
        else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New balance: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) { throw new InvalidAmount("Invalid amount.");}
        else {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        }
    }

    @Override
    public double checkBalance() { return balance; }
}
