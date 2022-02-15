public class LoanCalculation {

    private BankAccount bankAccount;
    private  double currentPercentUser;
   //здесь будут первые подсчёты, следующие подсчёты при отнятии месяцев должны быть в отдельном классе
    public LoanCalculation(BankAccount bankAccount,  double currentPercentUser) {
        this.bankAccount = bankAccount;
        this.currentPercentUser = currentPercentUser;//какая ставка сейчас в банке
    }

    void interestRateMethod(){//сколько процентов надо платить
       double discount = 0;

        if(bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.NO_BENEFITS)){

            customerCosting(bankAccount, currentPercentUser);

        } else if (bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.DISABILITY_ONE_TWO)){
            //57
            discount = 0.57;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        }

     }



     void customerCosting(BankAccount bankAccount,  double currentPercentUser){ //будет подсчёт всех неободимых вещей в банке
         double countMonth = bankAccount.getCredit().getMonthsToPay();
         double year = countMonth / 12;
         double onePercent = bankAccount.getCredit().getHowMuchIsTheLoan() / 100; // 1 процент
         double percentOverpaid = onePercent * currentPercentUser * year;//тут мы узнаем сколько сверху надо заплатить
         double paymentAmountPercent = bankAccount.getCredit().getHowMuchToPay() + percentOverpaid; //платёж общий с процентами
         double resultPaymentMonth = paymentAmountPercent / countMonth;  //сколько в месяц с процентами

         bankAccount.getCredit().setHowMuchToPay(paymentAmountPercent);
         bankAccount.getCredit().setPercentRate(currentPercentUser);
         bankAccount.getCredit().setPaid(0);
         bankAccount.getCredit().setTheTotalAmountYouPay(paymentAmountPercent);
         bankAccount.getCredit().setMonthsToPay(countMonth);
         bankAccount.getCredit().setBankProfit(percentOverpaid);
         bankAccount.getCredit().setPaymentPerMonth(resultPaymentMonth);
     }

     //нужна формула расчёта на каждый месяц, с каждым месяцем надо меньше платить процентов. к пример разделили на 100
    //и с каждой новой суммы надо делать новые вычеты

     //    NO_BENEFITS,
    //    DISABILITY_ONE_TWO,
    //    DISABILITY_THREE_FOUR,
    //    THE_LARGE_FAMILY,
    //    PENSIONER,
    //    VETERAN
}
