// ATM Simulator
// A small Java project where a user can login with a PIN
// and do basic bank work like deposit and withdraw.

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    String name;
    int pin;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    Account(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        history.add("Deposited: " + amount);
        System.out.println("Amount deposited. New balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance.");
        } else {
            balance = balance - amount;
            history.add("Withdrawn: " + amount);
            System.out.println("Please collect cash. New balance: " + balance);
        }
    }

    void showHistory() {
        if (history.size() == 0) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("--- Mini Statement ---");
        for (String h : history) {
            System.out.println(h);
        }
    }
}

public class AtmSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account user = new Account("Suryansh", 1234, 5000);

        System.out.println("Welcome to ATM");
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != user.pin) {
            System.out.println("Wrong PIN. Card blocked for this session.");
            return;
        }
        System.out.println("Hello " + user.name);

        while (true) {
            System.out.println("\n1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Mini statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Your balance is: " + user.balance);
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amt = sc.nextDouble();
                if (amt > 0) user.deposit(amt);
                else System.out.println("Enter a valid amount.");
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();
                if (amt > 0) user.withdraw(amt);
                else System.out.println("Enter a valid amount.");
            } else if (choice == 4) {
                user.showHistory();
            } else if (choice == 5) {
                System.out.println("Thank you for using ATM.");
                break;
            } else {
                System.out.println("Wrong choice.");
            }
        }
        sc.close();
    }
}
