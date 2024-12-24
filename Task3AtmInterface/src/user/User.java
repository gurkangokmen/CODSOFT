package user;

// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
public interface User {
    void withdraw(double amount);
    void deposit(double amount);
    double checkBalance();
}
