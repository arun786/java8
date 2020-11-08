package com.arun.introduction;

/**
 * @author arun on 11/2/20
 */
public class RunnableUsingTraditionalWay {

    public static void main(String[] args) throws InterruptedException {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread " + i + " : " + Thread.currentThread());
                }
            }
        };

        Thread thread = new Thread(run);
        thread.start();
        thread.join();
    }
}
