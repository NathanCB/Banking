import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Atm atm = new Atm();
        atm.loadAccount();// loads the preexisting hashmap values
        atm.inputName(); // prompts for name and stores it for validating
        atm.isAccountFoundAndValid();//validates name

        if(atm.isAccountFoundAndValid()){
            atm.chooseOption();
        }
        else {
            atm.openFirstAccount();
        }

        //if (atm.isAccountFoundAndValid();
        // if val
        //   process act
        // else offer create new
        // if created
        //   process act
    }

}