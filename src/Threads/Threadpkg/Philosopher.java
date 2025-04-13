package Threads.Threadpkg;

public class Philosopher extends Thread{
    ChopStick leftStick, rightStick;
    int position;

    public Philosopher(int pos, ChopStick lStick, ChopStick rStick) {
        position = pos;
        leftStick = lStick;
        rightStick = rStick;
    }

    public void eat() {
        leftStick.getUp();
        rightStick.getUp();

        System.out.println("The " + position + " (th) philosopher is eating!");
    }

    public void think() {
        leftStick.getDown();
        rightStick.getDown();

        System.out.println("The " + position + " (th) philosopher is thinking!");
    }

    @Override
    public void run() {
        while (true) {
            eat();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            think();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
