import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoanCalculationTest {
    @Test
    public void DISABILITY_ONE_TWOTest(){
        User user = new User("Ruslan", "Pankratov",25, TypeOfBenefits.DISABILITY_ONE_TWO);
        Transaction transaction = new Transaction(1000.35f, TransactionType.DEPOSIT);
        CreditCard creditCard = new CreditCard(false,"regularRig876", "1111", 7834f);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(10000f, TransactionType.DEPOSIT));
        transactions.add(new Transaction(10000f, TransactionType.WITHDRAWAL));
        transactions.add(new Transaction(10000f, TransactionType.DEPOSIT));
        Credit credit = new Credit(300000, 258);
        Insurance insurance = new Insurance(0,0);
        BankAccount bankAccount = new BankAccount(user,transaction,creditCard, 2f, transactions,credit,  insurance);


        LoanCalculation loanCalculation = new LoanCalculation(bankAccount, 5);

        assertEquals(bankAccount.getCredit().getPaymentPerMonth(), 1762, 0.01);

    }

}