package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed;

public class FixedTermAccount implements DepositOnlyAccount{

    private double balance;

    public FixedTermAccount(){
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " in FixedTermAccount. New balance: $" + balance);
    }
}
