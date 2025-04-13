package Threads.Bai1_Counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(50);
            thread2.join(50);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

        int count = counter.getCounter();
        System.out.println("Số lần đếm được: " + count);
    }
}
