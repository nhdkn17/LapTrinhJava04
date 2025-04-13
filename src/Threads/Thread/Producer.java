package Threads.Thread;

public class Producer extends Thread{
    Store store = null;
    long index = 1;

    public Producer(Store s) {
        store = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                boolean result = store.put(index);

                if (result == true)
                    System.out.println("** Producer " + (index++) + " is made!");
                else System.out.println("Store is full!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
