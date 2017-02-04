import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Atm atm = new Atm();
        atm.loadAccount();
        atm.inputName();
        atm.isAccountFoundAndValid();

        if(atm.isAccountFoundAndValid()){
            atm.chooseOption();
        }
        else {System.out.println("Would you like to open a new account?");
        }




        //if (atm.isAccountFoundAndValid();
        // if val
        //   process act
        // else offer create new
        // if created
        //   process act










    }

}
