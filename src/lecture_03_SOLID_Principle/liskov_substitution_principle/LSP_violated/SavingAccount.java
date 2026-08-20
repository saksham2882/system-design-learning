package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated;

public class SavingAccount implements Account{

    private double balance;

    public SavingAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing: $" + amount + " in Savings Account. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from Savings Account. New Balance: $" + balance);
        } else {
            System.out.println("Not enough money in Savings Account.");
        }
    }
}
