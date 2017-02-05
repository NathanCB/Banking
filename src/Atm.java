import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Atm {
    String name;
    Double balance;
    Double deposit;
    HashMap<String, Double> accounts = new HashMap();

    public void loadAccount() {
        accounts.put("Alice", 2050.89);
        accounts.put("Nathan", 100.99);
        accounts.put("Sarah", 300.02);
    }

    static Scanner scanner = new Scanner(System.in);

    public void inputName() {
        name = "";
        while (name.isEmpty()) {
            System.out.println("Please enter a name.");
            name = Atm.scanner.nextLine();
        }
        System.out.println("Hi " + name);
    }

    public boolean isAccountFoundAndValid() {
        return accounts.containsKey(name);
    }

    public void openFirstAccount() {
        System.out.println("To open a new account enter y \npress any other key to exit");
        String c = Atm.scanner.nextLine();
        if (c.contentEquals("y")) {
            createAccount();
        } else {
            System.out.println("End of transaction");
            inputName();
        }
    }

    public void chooseOption() {
        System.out.println("\nTo open a new account press 1" +
                "\nTo close or delete account press 2" + "\nTo Check balance press 3" + "\nWithdraw cash press 4" + "\nTo Cancel press 5.");

        int selectedInput = Atm.scanner.nextInt();

        switch (selectedInput) {

            case 1:
                selectedInput = 1;
                System.out.println("Open account.");
                createAccount();
                break;

            case 2:
                selectedInput = 2;
                System.out.println("Delete account.");
                removeAccount();
                break;

            case 3:
                selectedInput = 3;
                System.out.println("Check balance.");
                if (accounts.containsKey(name)) {
                    System.out.printf("Balance = $%.2f\n", accounts.get(name));
                } else {
                    System.out.println("Please open an account");
                }

                break;

            case 4://withdraw money
                selectedInput = 4;

                withdrawMoney();
                break;

            case 5:
                selectedInput = 5;
                System.out.println("Thank you come again.");

                break;
        }

    }

    private void removeAccount() {
        accounts.remove(name);
    }

    private void createAccount() {
        System.out.println("Enter amount to deposit.");
        deposit = Atm.scanner.nextDouble();
        accounts.put(name, deposit);
        System.out.println("Now that you have created an account what would you like to do next?");
        chooseOption();
    }

    public void withdrawMoney() {
        //checkBalance();
        System.out.println("Enter amount to withdraw");
        Double cashOut = Atm.scanner.nextDouble();
        Double newBalance = accounts.get(name) - cashOut;
        if (balance > 100 && balance - cashOut >= balance) {
            accounts.put(name,newBalance);
            System.out.println("Please remove your cash. Thank You!");
        }
        else {
            System.out.println("You need to have more than 100 in your account to withdraw money.");

        }
        chooseOption();
    }

    public void checkBalance(){
        Double balance = accounts.get(name);

    }


}