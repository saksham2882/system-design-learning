package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated;

public class FixedTermAccount implements Account{

    private double balance;

    public FixedTermAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " in Fixed Term account. New balance: $" + balance);
    }

    // -> here withdraw is not allowed
    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdraw is not allowed in FixedTermAccount");
    }
}
