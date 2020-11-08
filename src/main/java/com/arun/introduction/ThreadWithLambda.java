package com.arun.introduction;

/**
 * @author arun on 11/2/20
 */
public class ThreadWithLambda {

    public static void main(String[] args) throws InterruptedException {

        Runnable run = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread " + i + " : " + Thread.currentThread());
            }
        };

        Thread t = new Thread(run);

        t.start();
        t.join();
    }
}
