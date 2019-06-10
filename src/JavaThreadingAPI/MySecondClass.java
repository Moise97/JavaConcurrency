package JavaThreadingAPI;

public class MySecondClass implements Runnable {

    @Override
    public void run() {
        for(int i=0; i <= 100; i++) {
            System.out.println("Hello, from another thread");
        }
    }
}
