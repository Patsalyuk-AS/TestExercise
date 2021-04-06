package com.github.patsalyukas.test.latch;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
public class Worker implements Runnable {

    private int id;
    private CountDownLatch startSignal;
    private CountDownLatch endSignal;

    @Override
    public void run() {
        try {
            startSignal.await();
            System.out.printf("%d waiting to start...%n", id);

            System.out.printf("%d running to completion%n", id);
            endSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
