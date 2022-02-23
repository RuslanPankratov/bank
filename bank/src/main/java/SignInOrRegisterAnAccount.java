import java.util.Scanner;

public class SignInOrRegisterAnAccount {


    public static void main(String[] args) {
        while (true) {


            System.out.println("Enter or register?\n" +
                    "1: log in\n" +
                    "2: register");
            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();
            ListBankAccount listBankAccount = new ListBankAccount();

            if (result.equals("1")) {
                CardEntry cardEntry = new CardEntry(listBankAccount);
                while (true) {
                    System.out.println("Do you want to continue?Yes or no?");
                    String enter = scanner.nextLine();
                    if (enter.equalsIgnoreCase("no")) {
                        break;
                    }
                    System.out.println("Enter login and password");
                    String log = scanner.nextLine();
                    String pas = scanner.nextLine();

                    cardEntry.enter(log, pas);
                }

            } else if (result.equals("2")) {
                BankAccountCreation bankAccountCreation = new BankAccountCreation(listBankAccount);
                bankAccountCreation.createBankAccount();
            }
        }
    }
}
