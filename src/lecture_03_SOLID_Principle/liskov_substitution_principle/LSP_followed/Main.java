package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed;

import java.util.ArrayList;
import java.util.List;

public class Main {
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
