public class Credit {

    private double howMuchToPay; //надо выплатить ещё
    private double percentRate; // процентная ставка
    private double paid;//выплачено
    private double theTotalAmountYouPay;//сколько в общем надо выплатить
    private double monthsToPay; //количество месяцев ещё платить
    private double bankProfit; //прибыль банка
    private double howMuchIsTheLoan;// сколько берёт кредита человек
    private double paymentPerMonth;

    public Credit(double monthsToPay, double howMuchIsTheLoan) {
        this.monthsToPay = monthsToPay;
        this.howMuchIsTheLoan = howMuchIsTheLoan;
    }

    public double getPaymentPerMonth() {
        return paymentPerMonth;
    }

    public void setPaymentPerMonth(double paymentPerMonth) {
        this.paymentPerMonth = paymentPerMonth;
    }

    public double getHowMuchIsTheLoan() {
        return howMuchIsTheLoan;
    }

    public void setHowMuchIsTheLoan(double howMuchIsTheLoan) {
        this.howMuchIsTheLoan = howMuchIsTheLoan;
    }

    public double getMonthsToPay() {
        return monthsToPay;
    }

    public double getBankProfit() {
        return bankProfit;
    }

    public void setBankProfit(double bankProfit) {
        this.bankProfit = bankProfit;
    }

    public void setMonthsToPay(double monthsToPay) {
        this.monthsToPay = monthsToPay;
    }

    public double getHowMuchToPay() {
        return howMuchToPay;
    }

    public void setHowMuchToPay(double howMuchToPay) {
        this.howMuchToPay = howMuchToPay;
    }

    public double getPercentRate() {
        return percentRate;
    }

    public void setPercentRate(double percentRate) {
        this.percentRate = percentRate;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getTheTotalAmountYouPay() {
        return theTotalAmountYouPay;
    }

    public void setTheTotalAmountYouPay(double theTotalAmountYouPay) {
        this.theTotalAmountYouPay = theTotalAmountYouPay;
    }
}
