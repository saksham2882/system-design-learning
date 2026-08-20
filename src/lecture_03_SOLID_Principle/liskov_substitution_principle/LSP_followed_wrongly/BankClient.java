package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed_wrongly;

import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.Account;
import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.FixedTermAccount;

import java.util.List;

public class BankClient {

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


// NOTE: As we tightly coupled BankClient to check for FixedTermAccount (allow only deposit), if new type of account (suppose WithdrawAccount -> only allow to withdraw) will come in the future, then again change in this BankClient
// which violates Open-Close Principle