public class BankResults {

    private ListBankAccount listBankAccount;

    public BankResults(ListBankAccount listBankAccount) {
        this.listBankAccount = listBankAccount;
    }

    void numberOfClients(){
        System.out.println("number of clients" + listBankAccount.getBankAccountList().size());
    }

    void expectedProfit(){

          float expected = 0f;
        for (int i = 0; i < listBankAccount.getBankAccountList().size(); i++) {

      //      float profit = listBankAccount.getBankAccountList().get(i).getCredit().
          //  expected = expected +
        }
    }
}
