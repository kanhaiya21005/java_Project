import java.util.Scanner;

class ATM {
    private float balance = 0.0f;
    private int pin = 1408; // Use a single PIN variable
    private Scanner scanner = new Scanner(System.in); // Single Scanner object

    public void checkPin() {
        try {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin == pin) {
                menu();
            } else {
                System.out.println("Invalid PIN. Please try again.");
                checkPin();
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
            checkPin();
        }
    }

    public void menu() {
        while (true) {
            try {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check A/C Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> checkBalance();
                    case 2 -> withdraw();
                    case 3 -> deposit();
                    case 4 -> changePIN();
                    case 5 -> {
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void withdraw() {
        try {
            System.out.print("Enter withdrawal amount: ");
            float amount = scanner.nextFloat();
            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than zero.");
                return;
            }
            if (amount > balance) {
                System.out.println("Error: Insufficient balance.");
                return;
            }
            System.out.print("Re-enter your PIN to confirm: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin == pin) {
                balance -= amount;
                System.out.println("Withdrawal successful! Remaining balance: " + balance);
            } else {
                System.out.println("Error: Invalid PIN.");
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void deposit() {
        try {
            System.out.print("Enter deposit amount: ");
            float amount = scanner.nextFloat();
            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than zero.");
                return;
            }
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void changePIN() {
        try {
            System.out.print("Enter current PIN: ");
            int currentPin = scanner.nextInt();
            if (currentPin == pin) {
                System.out.print("Enter new PIN: ");
                int newPin = scanner.nextInt();
                System.out.print("Confirm new PIN: ");
                int confirmPin = scanner.nextInt();
                if (newPin == confirmPin) {
                    pin = newPin;
                    System.out.println("PIN changed successfully.");
                } else {
                    System.out.println("Error: PINs do not match. Try again.");
                }
            } else {
                System.out.println("Error: Incorrect current PIN.");
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.checkPin();
    }
}
