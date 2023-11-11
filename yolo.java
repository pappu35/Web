import java.util.Scanner;

interface yolo {
    double checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

class SimpleATM implements ATM {
    private double balance;

    public SimpleATM(double balance) {
        this.balance = balance;
    }

    @Override
    public double checkBalance() {
        System.out.println("Your balance: $" + balance);
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Your new balance: $" + balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new SimpleATM(1000.0);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextInt()) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine(); // Consume the newline character
            scanner.nextLine(); // Wait for Enter key press
        }
    }
}
