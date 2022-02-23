import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoanCalculationTest {




    @Test
    public void DISABILITY_ONE_TWOTest(){
        BankAccount bankAccount = create();
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();

        assertEquals(438675.0,bankAccount.getCredit().getHowMuchToPay(),  0.01);
        assertEquals(2.15,bankAccount.getCredit().getPercentRate(),  0.01);
        assertEquals(0.0,bankAccount.getCredit().getPaid(),  0.01);
        assertEquals(438675.0,bankAccount.getCredit().getTheTotalAmountYouPay(),  0.01);
        assertEquals(258.0,bankAccount.getCredit().getCountMonthsToPay(),  0.01);
        assertEquals(138675.0,bankAccount.getCredit().getBankProfit(),  0.01);
        assertEquals(300000.0,bankAccount.getCredit().getHowMuchIsTheLoan(),  0.01);
        assertEquals(1700.29,bankAccount.getCredit().getPaymentPerMonth(),  0.01);

    }


    @Test
    public void NO_BENEFITSTest(){
        BankAccount bankAccount = create();
        bankAccount.getUser().setTypeOfBenefits(TypeOfBenefits.NO_BENEFITS);
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();
        assertEquals(2412.79,bankAccount.getCredit().getPaymentPerMonth(),  0.01);
       //322500
    }

    @Test
    public void DISABILITY_THREE_FOURTest(){
        BankAccount bankAccount = create();
        bankAccount.getUser().setTypeOfBenefits(TypeOfBenefits.DISABILITY_THREE_FOUR);
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();
        assertEquals(2150.29,bankAccount.getCredit().getPaymentPerMonth(),  0.01);
        //
    }

    @Test
    public void THE_LARGE_FAMILYTest(){
        BankAccount bankAccount = create();
        bankAccount.getUser().setTypeOfBenefits(TypeOfBenefits.THE_LARGE_FAMILY);
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();
        assertEquals(2062.79,bankAccount.getCredit().getPaymentPerMonth(),  0.01);
        //
    }


    @Test
    public void PENSIONERTest(){
        BankAccount bankAccount = create();
        bankAccount.getUser().setTypeOfBenefits(TypeOfBenefits.PENSIONER);
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();
        assertEquals(2287.79,bankAccount.getCredit().getPaymentPerMonth(),  0.01);
        //
    }

    @Test
    public void VETERANTest(){
        BankAccount bankAccount = create();
        bankAccount.getUser().setTypeOfBenefits(TypeOfBenefits.VETERAN);
        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);
        loanCalculation.interestRateMethod();
        assertEquals(2125.29,bankAccount.getCredit().getPaymentPerMonth(),  0.01);
        //
    }





    BankAccount create (){
        User user = new User("Ruslan", "Pankratov",25, TypeOfBenefits.DISABILITY_ONE_TWO);
        Transaction transaction = new Transaction(1000.35, TransactionType.DEPOSIT);
        CreditCard creditCard = new CreditCard(false,"regularRig876", "1111", 7834, 500000);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(10000, TransactionType.DEPOSIT));
        transactions.add(new Transaction(10000, TransactionType.WITHDRAWAL));
        transactions.add(new Transaction(10000, TransactionType.DEPOSIT));
        Credit credit = new Credit();
        credit.setCountMonthsToPay(258);
        credit.setHowMuchIsTheLoan(30000);
        Insurance insurance = new Insurance(0,0);
        BankAccount bankAccount = new BankAccount(user,transaction,creditCard, 2f, transactions,credit,  insurance);
        return bankAccount;
    }
}