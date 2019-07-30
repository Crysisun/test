import java.util.*;

public class Bank {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            switch(s) {
                case "balance":
                    acc.showBalance();
                    break;
                case "deposit":
                    System.out.println("Please type in the amount you want to deposit: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("You should type in numbers.");
                    } else {
                        acc.deposit(scanner.nextInt());
                    }
                    break;
                case "withdraw":
                    System.out.println("Please type in the amount you want to withdraw: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("You should type in numbers.");
                    } else {
                        acc.withdraw(scanner.nextInt());
                    }
                    break;
                case "info":
                    acc.printInfo();
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Please type in valid command.");
                    break;
            }
        }

    }
}
