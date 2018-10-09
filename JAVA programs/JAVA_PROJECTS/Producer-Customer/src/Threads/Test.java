package Threads;

public class Test {

    public static void main(String[] args) {

        int i;
        MyThread Ob = new MyThread();
        Thread thread = new Thread(Ob, "NameOfThread");
        thread.start();
        try {
            for (i = 0; i < 10; i++) {
                System.out.println("I am the Main thread " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Runnable {

    void print(int i) {
        System.out.println("I am a thread  " + i);
    }

    public void run() {
        int i;
        try {
            for (i = 0; i < 10; i++) {
                Thread.sleep(150);
                this.print(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}