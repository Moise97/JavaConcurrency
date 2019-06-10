package JavaThreadingAPI;

import java.applet.Applet;
import java.awt.*;

public class Animate extends Applet {

    private int count, lastcount;
    private Image[] pictures;
    private TimerThread timer;

    public void init() {
        count = 0; lastcount = 10;
        pictures = new Image[10];
        MediaTracker tracker = new MediaTracker(this);
        for(int i = 0; i < lastcount; i++) {
            pictures[i] = getImage(getCodeBase(), i + ".jpg");
            tracker.addImage(pictures[i], 0);
        }
        tracker.checkAll(true);
    }

    public void start() {
        timer = new TimerThread(this, 1000);
        timer.start();
    }

    public void stop() {
        timer.shouldRun = false;
        timer = null;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(pictures[count++], 0,0,null);
        if (count == lastcount) {
            count = 0;
        }
    }

}
