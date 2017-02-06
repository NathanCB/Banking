import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Atm {
    String name;
    Double deposit;
    String y;
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
        System.out.println("\nTo create an account press (1)" +
                "\nTo remove account press (2)" + "\nTo check balance press (3)" + "\nTo withdraw cash press (4)" +
                "\nTo deposit Cash press (5)" + "\nTo cancel press (6)");

        int selectedInput = Atm.scanner.nextInt();

        switch (selectedInput) {
            case 1:
                selectedInput = 1;
                createAccount();
                break;
            case 2:
                selectedInput = 2;
                if (accounts.containsKey(name)) {
                    removeAccount();
                } else {
                    System.out.println("You do not have an account. To open an account press the 'y' key.");
                    String y = Atm.scanner.nextLine();
                    createAccount();
                }
                break;
            case 3:
                selectedInput = 3;
                if (accounts.containsKey(name)) {
                    System.out.printf("Balance = $%.2f\n", accounts.get(name));
                } else {
                    System.out.println("You do not have an account. To open an account press the 'y' key.");
                    String y = Atm.scanner.nextLine();
                    createAccount();
                }
                break;
            case 4://withdraw money
                selectedInput = 4;
                if (accounts.containsKey(name)) {
                    withdrawMoney();
                } else {
                    System.out.println("You do not have an account. To open an account press the 'y' key.");
                    String y = Atm.scanner.nextLine();
                    createAccount();
                }
                break;
            case 5:
                selectedInput = 5;
                if (accounts.containsKey(name)) {
                    makeDeposit();
                } else {
                    System.out.println("You do not have an account. To open an account press the 'y' key.");
                    String y = Atm.scanner.nextLine();
                    createAccount();
                }
                break;
            case 6:
                selectedInput = 6;
                System.out.println("Thank you come again.");
                break;
        }

    }

    // Creates an account regardless of existing account. Will always ask for name and amount to deposit.
    private void createAccount() {
        System.out.println("Please enter a name to create an account.");
        String newAcctName = Atm.scanner.nextLine();
        System.out.println("Please enter the amount to open the account with.");
        Double newAcctDeposit = Atm.scanner.nextDouble();
        accounts.putIfAbsent(newAcctName, newAcctDeposit);
        System.out.println("Now that you have created an account what would you like to do next?");
    }

    public void removeAccount() {
        accounts.remove(name);
    }

    public void checkBalance() {
        Double balance = accounts.get(name);
        System.out.println("Your balance is" + name);
        chooseOption();
    }

    //adds money to existing account
    public void makeDeposit() {
        System.out.println("Please enter the amount to deposit.");
        deposit = Atm.scanner.nextDouble();
        accounts.put(name, deposit);
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw");
        Double cashOut = Atm.scanner.nextDouble();
        Double balance = accounts.get(name);
        Double minimumBalance = 100.00;
        if ((balance - cashOut) > minimumBalance) {
            Double newBalance = accounts.get(name) - cashOut;
            accounts.put(name, newBalance);
            System.out.println("Please remove your cash. Thank You!");
        } else {
            System.out.println("You need to have more than 100 in your account to withdraw money.");
        }
    }


}