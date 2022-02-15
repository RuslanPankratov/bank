import java.util.List;

public class BankAccount {
    private User user;
    private Transaction transaction;
    private CreditCard creditCard;
    private float clientId;
    private List<Transaction> transactions;
    private Credit credit;
    private Insurance insurance;

    public BankAccount(User user, Transaction transaction, CreditCard creditCard, float clientId, List<Transaction>
            transactions, Credit credit, Insurance insurance) {
        this.user = user;
        this.transaction = transaction;
        this.creditCard = creditCard;
        this.clientId = clientId;
        this.transactions = transactions;
        this.credit = credit;
        this.insurance = insurance;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public float getClientId() {
        return clientId;
    }

    public void setClientId(float clientId) {
        this.clientId = clientId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
