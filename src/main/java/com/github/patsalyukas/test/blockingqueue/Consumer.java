package com.github.patsalyukas.test.blockingqueue;

import lombok.AllArgsConstructor;

import java.util.concurrent.BlockingQueue;

@AllArgsConstructor
public class Consumer implements Runnable {

    private int id;
    private BlockingQueue<Message> queue;

    @Override
    public void run() {
        Message msg;
        try {
            while ((msg = queue.take()).getId() != -1) {
                System.out.printf("Consumer %d consumed %d%n", id, msg.getId());
                Thread.sleep((long) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}