package JavaThreadingAPI;

import java.awt.*;

public class TimerThread extends Thread{

    private Component component;        // Component that need repainting
    private int timediff;               // Time between repaints of the component
    volatile boolean shouldRun;         // Set to false to stop thread

    TimerThread(Component component, int timediff) {
        this.component = component;
        this.timediff = timediff;
        this.shouldRun = true;
    }

    public void run() {
        while(shouldRun) {
            component.repaint();
            try {
                sleep(timediff);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
