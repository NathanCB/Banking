import java.util.HashMap;
import java.util.Scanner;

public class Atm {
    String name;  // current user
    HashMap<String, Double> accounts = new HashMap();

    public void loadAccount() {
        accounts.put("Alice", 2050.89);
        accounts.put("Nathan", 100.99);
        accounts.put("Sarah", 300.02);
    }

    static Scanner scanner = new Scanner(System.in);
    static Scanner scanForString = new Scanner(System.in);
//    static Scanner scanForDouble = new Scanner(System.in);

    public void inputName() {
        System.out.println("Enter Your name: ");
        name = scanForString.nextLine();
        while (name.isEmpty()) {
            System.out.println("Please enter a name if you haven't.");
            name = Atm.scanner.nextLine();
        }
        System.out.println("Hi " + name);
    }

    public boolean isAccountValid() {
        return accounts.containsKey(name);
    }

    public void processOptions() {
        while (true) {
            System.out.println("\nTo create an account press (1)" +
                    "\nTo remove account press (2)" + "\nTo check balance press (3)" + "\nTo withdraw cash press (4)" +
                    "\nTo cancel press (5)");

            int selectedInput = Atm.scanner.nextInt();

            if (selectedInput == 1) {
                createAccount();
            } else if (selectedInput == 2) {
                removeAccount();
            } else if (selectedInput == 3) {
                System.out.printf("Balance = $%.2f\n", accounts.get(name));
            } else if (selectedInput == 4) {
                withdrawMoney();
            } else {
                break;
            }
        }
    }

    public void createAccount() {
//        String newAcctName = Atm.scanner.nextLine();
        System.out.println("Please enter the amount to deposit.");
        Double newAcctDeposit = Atm.scanner.nextDouble();
        accounts.put(name, newAcctDeposit);
    }

    public void removeAccount() {
        accounts.remove(name);
    }

    public void checkBalance() {
        Double balance = accounts.get(name);
        System.out.println("Your balance is" + name);
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