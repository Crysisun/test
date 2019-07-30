public class BankAccount {
    private long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;
    public BankAccount() {
        accountNumber = 123456789;
        balance = 50.0;
        customerName = "Qingyu";
        email = "qingyusu@usc.edu";
        phoneNumber = 2132454730;
        System.out.println("You can deposit, withdraw and check account balance.");
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds " + customerName);
            return;
        }
        balance -= amount;
    }
    public void printInfo() {
        System.out.println(customerName);
        System.out.println(accountNumber);
        System.out.println(balance);
        System.out.println(email);
        System.out.println(phoneNumber);
    }
}
