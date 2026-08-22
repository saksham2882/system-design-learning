package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_followed;

import java.util.ArrayList;
import java.util.List;


// 1. DepositOnlyAccount interface: only allows deposits
interface DepositOnlyAccount {
    public void deposit(double amount);
}


// 2. WithdrawableAccount interface: allows deposits and withdrawals
interface WithdrawableAccount extends DepositOnlyAccount{
    public void withdraw(double amount);
}


class SavingAccount implements WithdrawableAccount{
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


class CurrentAccount implements WithdrawableAccount{
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


class FixedTermAccount implements DepositOnlyAccount{
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


class BankClient {

    private List<WithdrawableAccount> withdrawableAccountList =  new ArrayList<>();

    private List<DepositOnlyAccount>  depositOnlyAccountList =  new ArrayList<>();

    public BankClient(List<WithdrawableAccount> withdrawableAccountList, List<DepositOnlyAccount> depositOnlyAccountList) {
        this.withdrawableAccountList = withdrawableAccountList;
        this.depositOnlyAccountList = depositOnlyAccountList;
    }

    public void processTransactions() {
        for(WithdrawableAccount withdrawableAccount : withdrawableAccountList){
            withdrawableAccount.deposit(1000);
            withdrawableAccount.withdraw(180);
        }
        for(DepositOnlyAccount depositOnlyAccount : depositOnlyAccountList){
            depositOnlyAccount.deposit(5000);
        }
    }
}



public class LSPFollowed {
    static void main() {

        List<WithdrawableAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingAccount());
        withdrawableAccounts.add(new CurrentAccount());

        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedTermAccount());

        BankClient bankClient = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        bankClient.processTransactions();
    }
}
