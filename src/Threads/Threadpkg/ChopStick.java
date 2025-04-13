package Threads.Threadpkg;

public class ChopStick {
    boolean ready;

    public ChopStick() {
        ready = true;
    }

    public synchronized void getUp() {
        while (!ready) {
            try {
                System.out.println("A philosopher is waiting for a chopstick!");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ready = false;
    }

    public synchronized void getDown() {
        ready = true;
        notify();
    }
}
