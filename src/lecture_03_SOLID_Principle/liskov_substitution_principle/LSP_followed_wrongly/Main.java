package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed_wrongly;

import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.Account;
import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.CurrentAccount;
import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.FixedTermAccount;
import lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_violated.SavingAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        List<Account>  accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}
