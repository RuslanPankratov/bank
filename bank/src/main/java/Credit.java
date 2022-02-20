import java.util.Objects;

public class Credit {

    private double howMuchToPay; //надо выплатить ещё
    private double percentRate; // процентная ставка
    private double paid;//выплачено
    private double theTotalAmountYouPay;//сколько в общем надо выплатить
    private double countMonthsToPay; //количество месяцев ещё платить
    private double bankProfit; //прибыль банка
    private double howMuchIsTheLoan;// сколько берёт кредита человек
    private double paymentPerMonth;//сколько в месяц платить


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

    public double getCountMonthsToPay() {
        return countMonthsToPay;
    }

    public double getBankProfit() {
        return bankProfit;
    }

    public void setBankProfit(double bankProfit) {
        this.bankProfit = bankProfit;
    }

    public void setCountMonthsToPay(double countMonthsToPay) {
        this.countMonthsToPay = countMonthsToPay;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Double.compare(credit.howMuchToPay, howMuchToPay) == 0 && Double.compare(credit.percentRate, percentRate) == 0 && Double.compare(credit.paid, paid) == 0 && Double.compare(credit.theTotalAmountYouPay, theTotalAmountYouPay) == 0 && Double.compare(credit.countMonthsToPay, countMonthsToPay) == 0 && Double.compare(credit.bankProfit, bankProfit) == 0 && Double.compare(credit.howMuchIsTheLoan, howMuchIsTheLoan) == 0 && Double.compare(credit.paymentPerMonth, paymentPerMonth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(howMuchToPay, percentRate, paid, theTotalAmountYouPay, countMonthsToPay, bankProfit, howMuchIsTheLoan, paymentPerMonth);
    }
}
