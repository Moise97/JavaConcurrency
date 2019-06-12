package SynchronizationTechniques;

public class BusyFlag {

    private Thread busyFlag = null;

    public void getBusyFlag() {

        while(!tryGetBusyFlag()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private synchronized boolean tryGetBusyFlag() {

        if(busyFlag == null) {
            busyFlag = Thread.currentThread();
            return true;
        }
        return false;
    }

    public synchronized void freeBusyFlag() {
        if(busyFlag == Thread.currentThread()) {
            busyFlag = null;
        }
    }

}
