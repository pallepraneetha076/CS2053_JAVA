class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) throws LowBalanceException {
        System.out.println("Processing withdrawal of: " + amount);

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            throw new LowBalanceException("Insufficient funds! Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Account No.: " + accountNumber + " | Current Balance: " + balance);
    }
}

public class Lab6 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC2002", 7000);

        account.displayBalance();

        try {
            account.withdraw(1500);  
            account.withdraw(3000);  
        } 
        catch (LowBalanceException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Built-in Exception caught: " + e.getMessage());
        } 
        finally {
            System.out.println("Transaction process completed. Thank you for banking with us!");
        }
    }
}
