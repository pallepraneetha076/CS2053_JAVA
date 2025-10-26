abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void displayDetails() {
        System.out.println("Account No.: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.04; // 4% interest

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest for Savings Account: $" + interest);
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }

    public void checkOverdraft() {
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("SA123", 10000);
        Account acc2 = new CurrentAccount("CA456", 20000);

        System.out.println("--- Savings Account ---");
        acc1.displayDetails();
        acc1.calculateInterest();

        System.out.println("\n--- Current Account ---");
        acc2.displayDetails();
        acc2.calculateInterest();
    }
}
