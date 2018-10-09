package com.company;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private  BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public static void main(String[] args) {
        Main m = new Main();
        Thread thread = new Thread( new Runnable(){

            @Override
            public void run() {
                try {
                    m.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
         }
        );

        Thread thread2 = new Thread(() -> {
            try {
                m.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );


        thread.start();
        thread2.start();
    }

    private void producer() throws InterruptedException {
        Random random = new Random();
        while(true){
            queue.put(random.nextInt(100));
        }
    }

    private void consumer() throws InterruptedException {
        Random random = new Random();
        while(true){
            Thread.sleep(100);

            if(random.nextInt(10) == 9){
              Integer value =  queue.take();
                System.out.println("Taken value: " + value + " Queue Size " + queue.size());
            }
        }

    }
}
