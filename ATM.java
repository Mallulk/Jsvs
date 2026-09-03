import java.util.Scanner;
 
public class ATM{
    static Scanner sc = new Scanner(System.in);
    static int pin = 1234;
    static double balance = 10000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Thank you for using ATM!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void login() {

        System.out.print("\nEnter PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            System.out.println("Login Successful!");

            atmMenu();
        } else {
            System.out.println("Wrong PIN!");
        }
    }
    static void atmMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        }
        static void deposit() {
            System.out.print("\nEnter amount to deposit: ");
            double amount = sc.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount deposited successfully!");
                System.out.println("Current Balance: ₹" + balance);
            } else {
                System.out.println("Invalid amount!");
            }
        }
            static void withdraw() {
                System.out.print("\nEnter amount to withdraw: ");
                double amount = sc.nextDouble();
                if (amount <=0){
                    System.out.println("Invalid amount!");
                } else if (amount > balance) {
                    System.out.println("Insufficient balance!");
                } else {
                    balance = balance - amount;
                    System.out.println("please collect your cash.");
                    System.out.println("Remaining balance: ₹" + balance);
                    
                }
            }
            static void checkBalance() {
                System.out.println("\nCurrent Balance: ₹" + balance);
            }
            static void changePin() {
                System.out.print("\nEnter current PIN: ");
                int currentPin = sc.nextInt();
                if (currentPin == pin) {
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();
                    pin = newPin;
                    System.out.println("PIN changed successfully!");
                } else {
                    System.out.println("Wrong current PIN!");
                }
            }
        }
        