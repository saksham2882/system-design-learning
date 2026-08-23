package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.properties_rules.history_constraint_rule;

// Subclass methods should not be allowed state changes that the base class never allowed.

class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        if(balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if(balance - amount < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdraw Successful. Remaining Balance: " + balance);
    }
}


class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(double balance) {
        super(balance);
    }

    // LSP break! History constraint broken!
    // Parent class behavior changed: Now withdraw is not allowed.
    // This class will break client code that relies on withdraw.
    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


public class HistoryConstraint {
    static void main() {

        BankAccount bankAccount = new BankAccount(1000);
        bankAccount.withdraw(100);

        // FixedDepositAccount fixedDepositAccount = new FixedDepositAccount(1000);
        // fixedDepositAccount.withdraw(100);
    }
}
