import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardEntry {//вход на карту

    public static void main(String[] args) {
        User user = new User("Ruslan", "Pankratov", 25, TypeOfBenefits.DISABILITY_ONE_TWO);
        Transaction transaction = new Transaction(1000.35, TransactionType.DEPOSIT);
        CreditCard creditCard = new CreditCard(false, "log", "1111", 7834, 500000);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(10000, TransactionType.DEPOSIT));
        transactions.add(new Transaction(10000, TransactionType.WITHDRAWAL));
        transactions.add(new Transaction(10000, TransactionType.DEPOSIT));
        Credit credit = new Credit();
        Insurance insurance = new Insurance(0, 0);
        BankAccount bankAccount = new BankAccount(user, transaction, creditCard, 2f, transactions, credit, insurance);

        ListBankAccount listBankAccount = new ListBankAccount();

        listBankAccount.setBankAccount(bankAccount);
        CardEntry cardEntry = new CardEntry(listBankAccount);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter login and password");
            String log = scanner.nextLine();
            String pas = scanner.nextLine();


            cardEntry.enter(log, pas);
        }

    }

    private ListBankAccount listBankAccount;
    private int countBlock = 5;//5 ошибок, блокировка аккаунта, если вводился логин, но пароль был не правильный

    public CardEntry(ListBankAccount listBankAccount) {
        this.listBankAccount = listBankAccount;
    }

    void enter(String login, String password) {

        for (int i = 0; i < listBankAccount.getBankAccountList().size(); i++) {
            String loginAccount = listBankAccount.getBankAccountList().get(i).getCreditCard().getLogin();
            String passwordAccount = listBankAccount.getBankAccountList().get(i).getCreditCard().getPassword();

            if (loginAccount.equals(login)) {
                if (passwordAccount.equals(password)) {
                    if (!listBankAccount.getBankAccountList().get(i).getCreditCard().isBlocked()) {
                        countBlock = 5;
                        while (true) {
                            System.out.println("choose what you want");
                            System.out.println("1: withdrawal or deposit");
                            System.out.println("2: credit");
                            System.out.println("3: insurance");
                            System.out.println("4: editing information");

                            Scanner scanner = new Scanner(System.in);
                            String choice = scanner.nextLine();


                            if (choice.equals("1")) {
                                methodDepositAndWithdrawal(i);


                            } else if (choice.equals("2")) {
                                //операции кредита
                                //первое, это сколько я хочу взять кредита
                                //кредит будет автоматически сниматься с карты. в случае неуплаты кредита в 1 месяц,
                                // будет штраф в двойном размере за этот месяц
                                //второе ручное оплачивание
                                //третье посмотреть сколько осталось выплатить и количество месяцев и т.д.

                                methodCredit(i, listBankAccount.getBankAccountList().get(i));
                            } else if (choice.equals("3")) {
                                //страхование
                                while (true) {
                                    InsuranceCalculator insuranceCalculator = new InsuranceCalculator(
                                            listBankAccount.getBankAccountList().get(i).getInsurance());
                                    System.out.println("specify the type of insurance");
                                    System.out.println("house");
                                    System.out.println("items");
                                    System.out.println("health");
                                    System.out.println("car");

                                    String type = scanner.nextLine();
                                    System.out.println("enter the amount of the insurance object");
                                    double sum = scanner.nextDouble();

                                    insuranceCalculator.insurance(listBankAccount.getBankAccountList().get(i), sum, type);
                                    System.out.println("insurance for the amount = "
                                            + listBankAccount.getBankAccountList().get(i).getInsurance().getSumInsured());

                                    System.out.println("how much to pay = " + listBankAccount.
                                            getBankAccountList().get(i).getInsurance().getInsurancePaid());
                                    System.out.println("you want pay insurance? Yes or No?");
                                    Scanner scanner1 = new Scanner(System.in);
                                    String answer = scanner1.nextLine();

                                    if (answer.equalsIgnoreCase("yes")){
                                        PayForInsurance payForInsurance = new PayForInsurance();
                                        payForInsurance.payInsurance(listBankAccount.getBankAccountList().get(i));
                                        System.out.println("exit");
                                        break;
                                    }
                                }



                            } else if (choice.equals("4")) {
                                //возможно редактировать данные, к примеру пароль, тип инвалидности и т.д.

                                System.out.println("what do you want to edit?");
                                System.out.println("1: first and last name");
                                System.out.println("2: status");
                                String result = scanner.nextLine();
                                if (result.equals("1")){
                                    System.out.println("Enter your name");
                                    String firstName = scanner.nextLine();
                                    System.out.println("enter your last name");
                                    String lastName = scanner.nextLine();
                                    listBankAccount.getBankAccountList().get(i).getUser().setFirstName(firstName);
                                    listBankAccount.getBankAccountList().get(i).getUser().setLastName(lastName);
                                    System.out.println("now your name " + firstName + " and your last name " + lastName );

                                } else if (result.equals("2")){
                                    System.out.println( "select your status");
                                    System.out.println(" 1: NO_BENEFITS,\n" +
                                            "  2:  DISABILITY_ONE_TWO,\n" +
                                            "  3:  DISABILITY_THREE_FOUR,\n" +
                                            "  4:  THE_LARGE_FAMILY,\n" +
                                            "  5:  PENSIONER,\n" +
                                            "  6:  VETERAN");

                                    String resultType = scanner.nextLine();

                                    if (resultType.equals("1")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.NO_BENEFITS);
                                    } else   if (resultType.equals("2")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.DISABILITY_ONE_TWO);
                                    } else   if (resultType.equals("3")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.DISABILITY_THREE_FOUR);
                                    } else   if (resultType.equals("4")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.THE_LARGE_FAMILY);
                                    } else   if (resultType.equals("5")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.PENSIONER);
                                    } else   if (resultType.equals("6")){
                                        listBankAccount.getBankAccountList().get(i).getUser().setTypeOfBenefits(TypeOfBenefits.VETERAN);
                                    }


                                }

                            } else {
                                //в случае 5 раз подряд ошибки набирания пароля, будет заблокирован аккаунт
                                System.out.println("you have selected the wrong menu");
                            }

                        }
                    } else {
                        System.out.println("your card is blocked");
                    }
                } else {
                    countBlock--;
                    System.out.println("error, attempts left before blocking " + countBlock); //если будет 0, тогда будет блок
                    if (countBlock == 0) {
                        listBankAccount.getBankAccountList().get(i).getCreditCard().setBlocked(true);//будет заблокирована карта
                        System.out.println("your card is blocked");
                    }
                }


            }
        }

    }


    void methodDepositAndWithdrawal(int i) {

        Scanner scanner = new Scanner(System.in);
        //разделим выбор между депозитом и снятием денег
        System.out.println("1: withdrawal");
        System.out.println("2: deposit");
        String resultWithdrawalOrDeposit = scanner.nextLine();
        DepositOrWithdrawalCalculator depositOrWithdrawalCalculator =
                new DepositOrWithdrawalCalculator();

        if (resultWithdrawalOrDeposit.equalsIgnoreCase("1")) {
            //тут будет снятие денег
            System.out.println("enter amount");
            System.out.println("on account" + listBankAccount.getBankAccountList().get(i).getCreditCard().getInvoiceAmount());
            int summa = scanner.nextInt();

            if (summa < listBankAccount.getBankAccountList().get(i).getCreditCard().getWithdrawalLimit()) {

                if (summa < listBankAccount.getBankAccountList().get(i).getCreditCard().getInvoiceAmount()) {//сумма снятия денег не должна быть больше чем счёт
                    Transaction transaction = new Transaction(summa, TransactionType.WITHDRAWAL);
                    depositOrWithdrawalCalculator.calculator(listBankAccount.getBankAccountList().get(i), transaction);
                    System.out.println("on account" + listBankAccount.getBankAccountList().get(i).getCreditCard().getInvoiceAmount());
                } else {
                    System.out.println("you want to withdraw more than you have on your account");
                    //если попытка снятия денег больше, чем сама сума на карте
                }

            } else {
                System.out.println("you cannot withdraw that amount per day");
                //когда превышен дневной лимит
            }

        } else if (resultWithdrawalOrDeposit.equalsIgnoreCase("2")) {
            // а тут ложим деньги
            System.out.println("enter amount");
            int summa = scanner.nextInt();
            Transaction transaction = new Transaction(summa, TransactionType.DEPOSIT);
            depositOrWithdrawalCalculator.calculator(listBankAccount.getBankAccountList().get(i), transaction);
        }
    }


    //операции кредита

    //второе ручное оплачивание
    //третье посмотреть сколько осталось выплатить и количество месяцев и т.д.

    void methodCredit(int i, BankAccount bankAccount) {
        System.out.println("1: how much i want to borrow");
        System.out.println("2: manual payment ");
        System.out.println("3: current loan information");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();


        if (result.equals("1")) {

            if (bankAccount.getCredit().getCountMonthsToPay() <= 0) {
                //первое, это сколько я хочу взять кредита
                //кредит будет автоматически сниматься с карты. в случае неуплаты кредита в 1 месяц,
                // будет штраф в двойном размере за этот месяц
                System.out.println("how much do you want to take?");//какую вы сумму хотите взять?
                double credit = scanner.nextDouble();
                bankAccount.getCredit().setHowMuchIsTheLoan(credit);
                System.out.println("how many months do you want to pay");
                double month = scanner.nextDouble();
                bankAccount.getCredit().setCountMonthsToPay(month);


                LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
                loanCalculation.interestRateMethod();
            }


        } else if (result.equals("2")) {
            System.out.println("do you want to pay off the loan? Yes or No?");
            //проверка сколько должна быть сумма на уплату кредита
            String resultTwo = scanner.nextLine();
            if (resultTwo.equalsIgnoreCase("Yes")) {
                if (bankAccount.getCreditCard().getInvoiceAmount() >= bankAccount.getCredit().getPaymentPerMonth()) {//на
                    // счету должно быть больше или равно с количеством оплаты
                    LoanPaymentCalculator loanPaymentCalculator = new LoanPaymentCalculator();
                    loanPaymentCalculator.methodPay(bankAccount);
                    System.out.println("you paid");
                } else {
                    System.out.println("you don't have enough money on your card");
                }

            }


        } else if (result.equals("3")) {
            System.out.println("number of months left  =" + bankAccount.getCredit().getCountMonthsToPay());
            System.out.println("debt paid = " + bankAccount.getCredit().getPaid());
            System.out.println("how much more do you have to pay = " + bankAccount.getCredit().getHowMuchToPay());
            System.out.println("how much more do you have to pay month = " + bankAccount.getCredit().getPaymentPerMonth());
            System.out.println("account on the card = " + bankAccount.getCreditCard().getInvoiceAmount());
        }


    }
}
