package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed;

import java.util.ArrayList;
import java.util.List;

public class BankClient {

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
