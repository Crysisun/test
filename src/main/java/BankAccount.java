public class BankAccount {
    private long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNumber;

    public BankAccount() {
        setAccountNumber(123456789);
        setBalance(50.0);
        setCustomerName("Qingyu");
        setEmail("qingyusu@usc.edu");
        setPhoneNumber(2132454730);
        System.out.println("You can deposit, withdraw and check account balance. Start by typing \"balance\", \"deposit\", \"withdraw\", and \"info\", or \"quit\".");
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    private long getAccountNumber() {
        return this.accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 50) {
            System.out.println("Unsuccessful! You can only deposit 50 dollars at each time.");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Successful!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Unsuccessful! Insufficient funds, " + customerName);
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Successful!");
        }

    }

    public void showBalance() {
        System.out.println(getBalance());
    }

    public void printInfo() {
        System.out.println("Customer's name: " + getCustomerName());
        System.out.println("Account number: " + getAccountNumber());
        System.out.println("Current balance: " + getBalance());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone number: " + getPhoneNumber());
    }
}
