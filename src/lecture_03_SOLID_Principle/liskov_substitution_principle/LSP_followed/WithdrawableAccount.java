package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_followed;

public interface WithdrawableAccount extends DepositOnlyAccount{

    public void withdraw(double amount);
}
