import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}

public class ATM {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount;

    public static void main(String[] args) {
        // Sample accounts
        accounts.put("12345", new Account("12345", "1111", 1000.0));
        accounts.put("67890", new Account("67890", "2222", 500.0));

        if (authenticateUser()) {
            showMainMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static boolean authenticateUser() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin().equals(pin)) {
            currentAccount = account;
            return true;
        }
        return false;
    }

    private static void showMainMenu() {
        int choice;
        do {
            System.out.println("Main Menu:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    balanceInquiry();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private static void balanceInquiry() {
        System.out.println("Current Balance: $" + currentAccount.getBalance());
    }

    private static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposit successful. New Balance: $" + currentAccount.getBalance());
    }

    private static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        currentAccount.withdraw(amount);
        System.out.println("Withdrawal successful. New Balance: $" + currentAccount.getBalance());
    }
}
