package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed;

public class CurrentAccount implements WithdrawableAccount{

    private double balance;

    public CurrentAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing: $" + amount + " in Current Account. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from Current Account. New Balance: $" + balance);
        } else {
            System.out.println("Not enough money in Savings Account.");
        }
    }
}
