package com.github.patsalyukas.test.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerDemo {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(1, queue);
        Consumer c1 = new Consumer(1, queue);
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(p1);
        service.execute(c1);
        service.shutdown();
    }

}
