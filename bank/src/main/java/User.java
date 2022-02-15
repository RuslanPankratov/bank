public class User {
    private String firstName;
    private String lastName;
    private int age;
    private TypeOfBenefits typeOfBenefits;

    public User(String firstName, String lastName, int age, TypeOfBenefits typeOfBenefits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.typeOfBenefits = typeOfBenefits;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public TypeOfBenefits getTypeOfBenefits() {
        return typeOfBenefits;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTypeOfBenefits(TypeOfBenefits typeOfBenefits) {
        this.typeOfBenefits = typeOfBenefits;
    }
}
