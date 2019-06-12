package SynchronizationTechniques;

/**
 * A banking example: ATM
 */

public class AutomatedTellerMachine extends Teller{

    Account account;

    public void withdraw(float amount) {

        if(account.deduct(amount)) {
            dispense(amount);
            printReceipt();
        }
    }

    public synchronized boolean login(String name, String password) {

        if(account != null) {
            throw new IllegalArgumentException("Already logged in");
        }
        account = verifyAccount(name, password);
        if(account == null) {
            return false;
        }
        account.lock();
        return true;
    }


    private Account verifyAccount(String name, String password) {
        if(name == null || password == null){
            return null;
        }
        return getAccount();
    }

    public void balanceInjury() {
        printBalance(account.balance());
    }

    private void printBalance(float balance) {
        System.out.println(balance);
    }

    private void printReceipt() {
    }

    private void dispense(float amount) {
    }

    private Account getAccount() {
        return new Account().setTotal(100);
    }

    public synchronized void logoff() {
        account.unlock();
        account = null;
    }

}
