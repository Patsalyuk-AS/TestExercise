package com.github.patsalyukas.test.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LockDemo {

    private Counter counter = new Counter();
    private SyncCounter syncCounter = new SyncCounter();
    private LockedCounter lockedCounter = new LockedCounter();
    private AtomicCounter atomicCounter = new AtomicCounter();

    public void demoCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(counter::increment));
        service.shutdown();
        System.out.println("Counter count = " + counter.getCount());
    }

    public void demoSyncCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(syncCounter::increment));
        service.shutdown();
        System.out.println("SyncCounter count = " + syncCounter.getCount());
    }

    public void demoLockedCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(lockedCounter::increment));
        service.shutdown();
        System.out.println("LockedCounter count = " + syncCounter.getCount());
    }

    public void demoAtomicCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(atomicCounter::increment));
        service.shutdown();
        System.out.println("AtomicCounter count = " + atomicCounter.getCount());
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.demoCounter();
        lockDemo.demoSyncCounter();
        lockDemo.demoLockedCounter();
        lockDemo.demoAtomicCounter();
    }
}
