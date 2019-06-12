package SynchronizationTechniques;

/**
 * A banking example: ATM
 */

public class AutomatedTellerMachine extends Teller {

    public void withdraw(float amount) {

        Account account = getAccount();
        if(account.deduct(amount)) {
            dispense(amount);
            printReceipt();
        }
    }

}
