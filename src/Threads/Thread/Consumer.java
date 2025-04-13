package Threads.Thread;

public class Consumer extends Thread{
    Store store = null;

    public Consumer(Store s) {
        store = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                long x = store.get();

                if (x > 0)
                    System.out.println("-- Product " + x + " is bought!");
                else System.out.println("Customer is waiting for new product!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
