public class Insurance {
    private float sumInsured;
    private float insurancePaid;

    public Insurance(float sumInsured, float insurancePaid) {
        this.sumInsured = sumInsured;
        this.insurancePaid = insurancePaid;
    }

    public float getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(float sumInsured) {
        this.sumInsured = sumInsured;
    }

    public float getInsurancePaid() {
        return insurancePaid;
    }

    public void setInsurancePaid(float insurancePaid) {
        this.insurancePaid = insurancePaid;
    }
}
