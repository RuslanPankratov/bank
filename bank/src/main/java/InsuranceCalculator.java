public class InsuranceCalculator {
    private Insurance insurance;

    public InsuranceCalculator(Insurance insurance) {
        this.insurance = insurance;
    }

    void insurance(BankAccount bankAccount, double sum, String typeInsurance) {

        if (typeInsurance.equalsIgnoreCase("house")) {
            houses(bankAccount, sum);
        } else if (typeInsurance.equalsIgnoreCase("items")) {
            items(bankAccount, sum);
        } else if (typeInsurance.equalsIgnoreCase("health")) {
            health(bankAccount, sum);
        } else if (typeInsurance.equalsIgnoreCase("car")) {
            car(bankAccount, sum);
        }

    }


    private void houses(BankAccount bankAccount, double sum) {
        calculate(bankAccount, sum, 200);
    }

    private void items(BankAccount bankAccount, double sum) {
        calculate(bankAccount, sum, 100);
    }

    private void health(BankAccount bankAccount, double sum) {
        calculate(bankAccount, sum, 110);
    }

    private void car(BankAccount bankAccount, double sum) {
        calculate(bankAccount, sum, 20);
    }


    private void calculate(BankAccount bankAccount, double sum, double percent) {
        double howMuchToPay = sum / percent;
        bankAccount.getInsurance().setSumInsured(bankAccount.getInsurance().getSumInsured() + sum);
        bankAccount.getInsurance().setInsurancePaid(bankAccount.getInsurance().getInsurancePaid() + howMuchToPay);
    }
}
