package com.github.patsalyukas.test.thread;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.concurrent.Callable;

@AllArgsConstructor
@ToString
public class MyCallable implements Callable<String> {

    private int id;

    @Override
    public String call() {
        return String.format("%s using thread %s", this, Thread.currentThread().getName());
    }
}
