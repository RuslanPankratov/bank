import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountCreation {
   private ListBankAccount bankAccountList;

    public BankAccountCreation(ListBankAccount bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    void createBankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter your full age");
        int age = scanner.nextInt();

        System.out.println("Push your status");
        System.out.println("1: NO_BENEFITS");
        System.out.println("2:  DISABILITY_ONE_TWO");
        System.out.println("3: DISABILITY_THREE_FOUR");
        System.out.println("4: THE_LARGE_FAMILY");
        System.out.println("5: PENSIONER");
        System.out.println("6:  VETERAN");
        Scanner scanner1 = new Scanner(System.in);
        String type = scanner1.nextLine();
        TypeOfBenefits typeOfBenefits = TypeOfBenefits.NO_BENEFITS;
        if (type.equalsIgnoreCase("1")) {


        } else if (type.equalsIgnoreCase("2")) {
            typeOfBenefits = TypeOfBenefits.DISABILITY_ONE_TWO;
        } else if (type.equalsIgnoreCase("3")) {
            typeOfBenefits = TypeOfBenefits.DISABILITY_THREE_FOUR;
        } else if (type.equalsIgnoreCase("4")) {
            typeOfBenefits = TypeOfBenefits.THE_LARGE_FAMILY;
        } else if (type.equalsIgnoreCase("5")) {
            typeOfBenefits = TypeOfBenefits.PENSIONER;
        } else if (type.equalsIgnoreCase("6")) {
            typeOfBenefits = TypeOfBenefits.VETERAN;
        }
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        User user = new User(firstName,lastName,age,typeOfBenefits);
        System.out.println("Enter your login");
        String login = scanner2.nextLine();
        System.out.println("Enter your password");
        String password = scanner3.nextLine();
        System.out.println("Enter enter a limit on withdrawing money at a time");
        double limit = scanner.nextDouble();
        CreditCard creditCard = new CreditCard(false,login,password,0,limit);
        float id = bankAccountList.getBankAccountList().size();
        BankAccount bankAccount = new BankAccount(user,creditCard, id);

        bankAccountList.getBankAccountList().add(bankAccount);
        System.out.println("ID" + id);


    }
    // private String login;
    //    private String password;
    //    private double invoiceAmount;
    //    private double withdrawalLimit;

    //private String firstName;
    //    private String lastName;
    //    private int age;
    //    private TypeOfBenefits typeOfBenefits;

    // NO_BENEFITS,
    //    DISABILITY_ONE_TWO,
    //    DISABILITY_THREE_FOUR,
    //    THE_LARGE_FAMILY,
    //    PENSIONER,
    //    VETERAN
}
