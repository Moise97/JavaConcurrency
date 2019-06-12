package SynchronizationTechniques;

public class Account {

    private float total;
    private BusyFlag busyFlag = new BusyFlag();

    public Account setTotal(float total) {
        this.total = total;
        return this;
    }

    public synchronized boolean deduct(float t) {
        if(t <= total) {
            total -= t;
            return true;
        }
        return false;
    }

    public synchronized float balance() {
        return total;
    }

    public void lock() {
        busyFlag.getBusyFlag();
    }

    public void unlock() {
        busyFlag.freeBusyFlag();
    }

}
