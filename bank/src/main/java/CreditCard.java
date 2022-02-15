public class CreditCard {
    private boolean blocked;
    private String login;
    private String password;
    private float invoiceAmount;


    public CreditCard(boolean blocked, String login, String password, float invoiceAmount) {
        this.blocked = blocked;
        this.login = login;
        this.password = password;
        this.invoiceAmount = invoiceAmount;
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

    public float getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(float invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}
