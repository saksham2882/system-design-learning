package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.properties_rules.class_invariants_rule;

// Class Invariant of a parent class Object should not be broken by child class Object.
// Hence, child class can either maintain or strengthen the invariant but never narrows it down.


// Invariant: Balance cannot be negative
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


// Breaks invariant: should not be allowed.
class CheatAccount extends BankAccount {
    public CheatAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;      // LSP break! Negative balance allowed
        System.out.println("Withdraw Successful. Remaining Balance: " + balance);
    }
}


public class ClassInvariants {
    static void main() {

        BankAccount bankAccount = new CheatAccount(100);
        // bankAccount.withdraw(100);
        bankAccount.withdraw(200);     // break bankAccount rule.
    }
}
