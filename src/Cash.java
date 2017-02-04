/**
 * Created by nathanbutler on 2/1/17.
 * This defines a method to handle paper currency withdrawals and deposits at an ATM.
 *
 */
public class Cash {
    int cashOut;

    public void withdrawMoney() throws Exception{
        int cashOut = Atm.scanner.nextInt();
        if (cashOut < 100){
            System.out.println("Please rub your head and pat your belly at the same time that you remove your cash. Thank You!");

        }

        else {throw new Exception("You outta cash! Come back soon and make some deposits. Good luck!");}

    }
}
