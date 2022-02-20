import java.util.Scanner;

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
            discount = 57;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        } else if(bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.DISABILITY_THREE_FOUR)){
            discount = 21;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        }else if(bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.THE_LARGE_FAMILY)){
            discount = 28;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        } else if(bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.PENSIONER)){
            discount = 10;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        } else if(bankAccount.getUser().getTypeOfBenefits().equals(TypeOfBenefits.VETERAN)){
            discount = 23;
            double count = currentPercentUser / 100 * discount;
            currentPercentUser = currentPercentUser - count;
            customerCosting(bankAccount,currentPercentUser);

        }

     }



     void customerCosting(BankAccount bankAccount,  double currentPercentUser){ //будет подсчёт всех неободимых вещей в банке
         double countMonth = bankAccount.getCredit().getCountMonthsToPay();
         double year = countMonth / 12;
         double onePercent = bankAccount.getCredit().getHowMuchIsTheLoan() / 100; // 1 процент
         double percentOverpaid = onePercent * currentPercentUser * year;//тут мы узнаем сколько сверху надо заплатить
         double paymentAmountPercent = bankAccount.getCredit().getHowMuchIsTheLoan() + percentOverpaid; //платёж общий с процентами
         double resultPaymentMonth = paymentAmountPercent / countMonth;  //сколько в месяц с процентами

         System.out.println("month pay " + resultPaymentMonth);
         System.out.println("how much do you have to pay " + percentOverpaid);
         System.out.println("total payment amount " + paymentAmountPercent);

         System.out.println("Are you sure you want to take out a loan? Yes or No");
         Scanner scanner = new Scanner(System.in);
         String result = scanner.nextLine();
         if (result.equalsIgnoreCase("Yes")){
             int attemptsToBlock = 5;
             while (!bankAccount.getCreditCard().isBlocked()){
                 System.out.println("Enter your password");
                 String password = scanner.nextLine();
                 if (password.equals(bankAccount.getCreditCard().getPassword())){
                     bankAccount.getCredit().setHowMuchToPay(paymentAmountPercent);
                     bankAccount.getCredit().setPercentRate(currentPercentUser);
                     bankAccount.getCredit().setPaid(0);
                     bankAccount.getCredit().setTheTotalAmountYouPay(paymentAmountPercent);
                     bankAccount.getCredit().setCountMonthsToPay(countMonth);
                     bankAccount.getCredit().setBankProfit(percentOverpaid);
                     bankAccount.getCredit().setPaymentPerMonth(resultPaymentMonth);
                     System.out.println("loan accepted");
                     break;
                 } else {
                    attemptsToBlock--;
                    if (attemptsToBlock == 0){
                        bankAccount.getCreditCard().setBlocked(true);//блокируем если исчерпаны попытки
                        System.out.println("your card is blocked");
                    }
                 }
             }



         } else {
             bankAccount.getCredit().setHowMuchIsTheLoan(0);
             bankAccount.getCredit().setCountMonthsToPay(0);

         }





     }
   //438 000
    // 1697.67  в месяц надо
     //нужна формула расчёта на каждый месяц, с каждым месяцем надо меньше платить процентов. к пример разделили на 100
    //и с каждой новой суммы надо делать новые вычеты

     //    NO_BENEFITS,
    //    DISABILITY_ONE_TWO,
    //    DISABILITY_THREE_FOUR,
    //    THE_LARGE_FAMILY,
    //    PENSIONER,
    //    VETERAN
}
