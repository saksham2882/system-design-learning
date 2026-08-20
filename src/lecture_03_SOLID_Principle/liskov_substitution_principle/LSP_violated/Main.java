package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);

        client.processTransactions();      // Throws exception when withdrawing from FixedTermAccount
    }
}
