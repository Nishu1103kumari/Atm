package internship;

import java.util.Scanner;

public class ATM {
	private static Scanner scanner = new Scanner(System.in);
	private static double accountBalance = 1000; // Initial account balance

	public static void main(String[] args) {
		System.out.println("Welcome to the ATM Interface!");
		showOptions();
		int choice = scanner.nextInt();

		while (choice != 5) {
			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				deposit();
				break;
			case 4:
				transfer();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
			showOptions();
			choice = scanner.nextInt();
		}

		System.out.println("Thank you for using the ATM Interface. Goodbye!");
		scanner.close();
	}

	private static void showOptions() {
		System.out.println("\nPlease select an option:");
		System.out.println("1. Check Account Balance");
		System.out.println("2. Withdraw Cash");
		System.out.println("3. Deposit Cash");
		System.out.println("4. Transfer Funds");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void checkBalance() {
		System.out.println("Your current account balance is: $" + accountBalance);
	}

	private static void withdraw() {
		System.out.print("Enter the amount to withdraw: $");
		double amount = scanner.nextDouble();

		if (amount > accountBalance) {
			System.out.println("Insufficient funds.");
		} else {
			accountBalance -= amount;
			System.out.println("Withdrawal successful. Remaining balance: $" + accountBalance);
		}
	}

	private static void deposit() {
		System.out.print("Enter the amount to deposit: $");
		double amount = scanner.nextDouble();
		accountBalance += amount;
		System.out.println("Deposit successful. Current balance: $" + accountBalance);
	}

	private static void transfer() {
		System.out.print("Enter the amount to transfer: $");
		double amount = scanner.nextDouble();

		if (amount > accountBalance) {
			System.out.println("Insufficient funds for transfer.");
		} else {
			System.out.print("Enter the recipient's account number: ");
			String recipientAccount = scanner.next();
			accountBalance -= amount;
			System.out.println("Transfer of $" + amount + " to account " + recipientAccount + " successful.");
			System.out.println("Remaining balance: $" + accountBalance);
		}
	}

}

