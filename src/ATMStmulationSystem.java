import java.util.Scanner;
public class ATMStmulationSystem {
    static final int PIN = 1234;
        static int balance = 0;

        // Deposit method
        static void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Withdraw method
        static void withdraw(int amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Not enough balance.");
            } else {
                balance -= amount;
                System.out.println("Amount withdrawn: " + amount);
            }
        }

        // Check balance method
        static void checkBalance() {
            System.out.println("Current balance: " + balance);
        }

        public static void main(String[] args) {
            Scanner S = new Scanner(System.in);

            // PIN tries loop
            int tries = 3;
            while (tries > 0) {
                System.out.print("Enter PIN: ");
                int enteredPin = S.nextInt();
                if (enteredPin == PIN) {
                    break;
                } else {
                    tries--;
                    System.out.println("Wrong PIN. Attempts left: " + tries);
                }
            }

            if (tries == 0) {
                System.out.println("Your account is locked.");

                return;
            }

            // Main menu loop
            while (true) {
                System.out.println("\nMenu");
                System.out.println("1. Deposit money");
                System.out.println("2. Withdraw money");
                System.out.println("3. Check your balance");
                System.out.println("4. Exit");

                System.out.print("Please enter your choice (1-4): ");
                int choice = S.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("How much money do you want  to deposit? ");
                        int depAmount = S.nextInt();
                        deposit(depAmount);
                        break;

                    case 2:
                        System.out.print("Enter amount of money to withdraw? ");
                        int witAmount = S.nextInt();
                        withdraw(witAmount);
                        break;

                    case 3:
                        checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for using  ATM.");
                        S.close();
                        return;

                    default:
                        System.out.println("There not a valid option. Please choose between 1 and 4.");
                }
            }
        }
}


