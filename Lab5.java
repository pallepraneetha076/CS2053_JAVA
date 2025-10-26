interface Loan {
    void calculateEMI(double principal, int years);
}

class HomeLoan implements Loan {
    private double interestRate = 0.075; // 7.5% annual interest

    @Override
    public void calculateEMI(double principal, int years) {
        double monthlyRate = interestRate / 12;
        int months = years * 12;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);
        System.out.printf("Monthly Home Loan EMI: %.2f%n", emi);
    }
}

class CarLoan implements Loan {
    private double interestRate = 0.09; // 9% annual interest

    @Override
    public void calculateEMI(double principal, int years) {
        double monthlyRate = interestRate / 12;
        int months = years * 12;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);
        System.out.printf("Monthly Car Loan EMI: %.2f%n", emi);
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Loan homeLoan = new HomeLoan();
        Loan carLoan = new CarLoan();

        System.out.println("--- Home Loan EMI Calculation ---");
        homeLoan.calculateEMI(500000, 10);

        System.out.println("\n--- Car Loan EMI Calculation ---");
        carLoan.calculateEMI(300000, 5);
    }
}
