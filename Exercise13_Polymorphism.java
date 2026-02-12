
/**
 * Write a description of class BankAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 class BankAccount
{
   protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: TZS %,.2f\n", balance);
        System.out.println("Account Type: General");
    }

    public double calculateInterest() {
        return 0;
    }
}

// SAVINGS ACCOUNT
class SavingsAccount extends BankAccount {
    private double interestRate;
    private final double MIN_BALANCE = 10000;

    public SavingsAccount(String accNo, String holder, double balance, double rate) {
        super(accNo, holder, balance);
        this.interestRate = rate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of TZS 10,000 required.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.printf("Interest of TZS %,.2f applied. New balance: TZS %,.2f\n", interest, balance);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
    }
}

// CURRENT ACCOUNT

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accNo, String holder, double balance, double overdraftLimit) {
        super(accNo, holder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Current");
    }
}

// FIXED DEPOSIT ACCOUNT

class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accNo, String holder, double balance,
                               double rate, int months) {
        super(accNo, holder, balance);
        this.interestRate = rate;
        this.maturityMonths = months;
        this.isMatured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (isMatured) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Account not matured yet!");
        }
    }

    public void checkMaturity() {
        if (maturityMonths >= 12) {
            isMatured = true;
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit");
    }
}

// BANK CLASS

class Bank {
    private BankAccount[] accounts;
    private int count = 0;

    public Bank(int size) {
        accounts = new BankAccount[size];
    }

    public void addAccount(BankAccount account) {
        accounts[count++] = account;
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest(); // Polymorphism
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            System.out.println("---------------------------");
            accounts[i].displayAccountInfo();
        }
    }

    public BankAccount findAccount(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }
}

// MAIN CLASS

public class Exercise13_Polymorphism {

    // Method Overloading
    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public static void transferMoney(BankAccount from, BankAccount to,
                                     double amount, String description) {
        System.out.println("Transfer Description: " + description);
        transferMoney(from, to, amount);
    }

    public static void transferMoney(BankAccount from, String toAccNo,
                                     double amount, Bank bank) {
        BankAccount to = bank.findAccount(toAccNo);
        if (to != null) {
            transferMoney(from, to, amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== BANKING SYSTEM TEST ===\n");

        SavingsAccount savings =
                new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);

        CurrentAccount current =
                new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);

        FixedDepositAccount fixed =
                new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);

        System.out.println("--- Testing Savings Account ---");
        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();
        savings.displayAccountInfo();

        System.out.println("\n--- Testing Current Account ---");
        current.displayAccountInfo();
        current.withdraw(1200000);
        System.out.println("Is overdrawn? " + current.isOverdrawn());

        System.out.println("\n--- Testing Fixed Deposit ---");
        fixed.displayAccountInfo();
        fixed.withdraw(500000);
        System.out.printf("Maturity amount: TZS %,.2f\n", fixed.getMaturityAmount());

        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        System.out.println("\n--- Bank Summary (Polymorphism) ---");
        bank.displayAllAccounts();
        System.out.printf("Total Deposits: TZS %,.2f\n", bank.getTotalDeposits());
        System.out.printf("Total Interest: TZS %,.2f\n", bank.getTotalInterest());

        System.out.println("\n--- Testing Transfers (Overloading) ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, savings, 30000, "Rent payment");

        System.out.println("\n=== END OF TEST ===");
    }
}