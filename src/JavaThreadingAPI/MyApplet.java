package JavaThreadingAPI;

import java.applet.Applet;

public class MyApplet extends Applet {

    public void init() {

        MyClass myClass = new MyClass();
        myClass.start();

        MySecondClass mySecondClass = new MySecondClass();
        Thread thread = new Thread(mySecondClass);
        thread.start();

    }

}
