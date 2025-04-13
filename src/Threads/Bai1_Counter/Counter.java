package Threads.Bai1_Counter;

public class Counter extends Thread{
    private int counter = 0;

    public synchronized void increase() {
        System.out.println("Count: " + counter++);
    }

    public int getCounter() {
        return counter;
    }
}
