public class Transaction {

    private float amount;
    private TransactionType transactionType;

    public Transaction(float amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }



    public float getAmount() {
        return amount;
    }




    public boolean isDeposit() {
        return TransactionType.DEPOSIT == this.transactionType;
    }

    public boolean isWithdrawal() {
        return TransactionType.WITHDRAWAL == this.transactionType;
    }

}
