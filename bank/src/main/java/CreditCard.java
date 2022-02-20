public class CreditCard {
    private boolean blocked;
    private String login;
    private String password;
    private double invoiceAmount;
    private double withdrawalLimit = 1400;//ограничение на снятие суммы денег за день,


    public CreditCard(boolean blocked, String login, String password, double invoiceAmount, double withdrawalLimit) {
        this.blocked = blocked;
        this.login = login;
        this.password = password;
        this.invoiceAmount = invoiceAmount;
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}
