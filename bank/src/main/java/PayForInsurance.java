public class PayForInsurance {


    void payInsurance(BankAccount bankAccount) {
        if (bankAccount.getInsurance().getInsurancePaid() < bankAccount.getCreditCard().getInvoiceAmount()) {
            bankAccount.getCreditCard().setInvoiceAmount(bankAccount.getCreditCard().getInvoiceAmount()
                    - bankAccount.getInsurance().getInsurancePaid()); //отнимаем с карты и убераем с долга сколько надо заплатить
            bankAccount.getInsurance().setInsurancePaid(0);
        }
    }
}
