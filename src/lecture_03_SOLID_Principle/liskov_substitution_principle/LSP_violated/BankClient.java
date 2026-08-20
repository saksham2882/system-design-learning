package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated;

import java.util.List;

public class BankClient {

    private final List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for(Account account: accounts) {
            account.deposit(1000);       // All accounts allow deposits

            // Assuming all accounts support withdrawal (LSP Violation)
            try {
                account.withdraw(200);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
