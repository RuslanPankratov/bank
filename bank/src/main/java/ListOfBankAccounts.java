import java.util.ArrayList;
import java.util.List;

public class ListOfBankAccounts {

    private List<BankAccount> bankAccounts = new ArrayList<>();


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
