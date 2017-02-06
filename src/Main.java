import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.loadAccount();// loads the preexisting accounts

        while (true) {
            atm.inputName();
            // Loop thru 3 options
            atm.processOptions();
        }
    }
}