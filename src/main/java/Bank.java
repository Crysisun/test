import java.util.*;
import java.sql.*;

public class Bank {
    public static void main(String[] args) throws SQLException {

        BankAccount acc = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if ("balance".equals(s)) {
                acc.showBalance();
            } else if ("deposit".equals(s)) {
                System.out.println("Please type in the amount you want to deposit: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("You should type in numbers.");
                } else {
                    acc.deposit(scanner.nextDouble());
                }
            } else if ("withdraw".equals(s)) {
                System.out.println("Please type in the amount you want to withdraw: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("You should type in numbers.");
                } else {
                    acc.withdraw(scanner.nextDouble());
                }
            } else if ("info".equals(s)) {
                acc.printInfo();
            } else if ("quit".equals(s)) {
                return;
            }
        }

    }
}
