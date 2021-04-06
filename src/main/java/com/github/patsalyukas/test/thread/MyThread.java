package com.github.patsalyukas.test.thread;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MyThread extends Thread{

    private int id;

    @Override
    public void run() {
        System.out.printf("This is a thread: %s.%n", this);
    }
}
