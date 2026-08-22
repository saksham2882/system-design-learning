package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_followed_wrongly;

import java.util.ArrayList;
import java.util.List;


interface Account {
    public void deposit(double amount);
    public void withdraw(double amount);
}


class SavingAccount implements Account {
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


class CurrentAccount implements Account {
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


class FixedTermAccount implements Account {
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


class BankClient {

    private final List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (Account account : accounts) {
            account.deposit(1000);

            // Checking account type explicitly
            if(account instanceof FixedTermAccount) {
                System.out.println("Skipping withdrawal for FixedTermAccount.\n");
            } else {
                try{
                    account.withdraw(300);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}


public class LSPFollowedWrongly {
    static void main() {

        List<Account>  accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}
