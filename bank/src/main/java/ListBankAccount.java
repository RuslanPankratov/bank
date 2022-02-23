import java.util.ArrayList;
import java.util.List;

public class ListBankAccount {

    private static List<BankAccount> bankAccountList = new ArrayList<>();

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }


    public void setBankAccount(BankAccount bankAccount){
        bankAccountList.add(bankAccount);
    }
}
