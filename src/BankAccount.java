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
        System.out.println("You can deposit, withdraw and check account balance. Start by typing \"balance\", \"deposit\", \"withdraw\", and \"info\", or \"quit\".");
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
    public void showBalance() {
        System.out.println(balance);
        return;
    }
    public void printInfo() {
        System.out.println("Customer's name: " + customerName);
        System.out.println("Account number " + accountNumber);
        System.out.println("Current balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);
    }
}
