public class Insurance {
    private double sumInsured;
    private double insurancePaid;

    public Insurance(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public double getInsurancePaid() {
        return insurancePaid;
    }

    public void setInsurancePaid(double insurancePaid) {
        this.insurancePaid = insurancePaid;
    }
}
