import java.util.Scanner;

public class BankAccount {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Insufficient funds. Unable to withdraw.");
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome " + customerName + " (ID: " + customerId + ")");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            System.out.print("Enter an option: ");
            option = scanner.next().charAt(0);

            switch (Character.toUpperCase(option)) {
                case 'A':
                    System.out.println("Balance: " + balance);
                    break;
                case 'B':
                    System.out.print("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;
                case 'C':
                    System.out.print("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a valid option.");
            }
            System.out.println();
        } while (Character.toUpperCase(option) != 'E');

        System.out.println("Thank you for using our services.");
        
    }
}