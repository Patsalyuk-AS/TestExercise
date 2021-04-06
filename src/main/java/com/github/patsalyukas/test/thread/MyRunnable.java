package com.github.patsalyukas.test.thread;

import lombok.ToString;

@ToString
public class MyRunnable implements Runnable{

    private int id;
//    private Thread thread = new Thread(this);

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.printf("This is a thread: %s.%n", this);
    }

//    public void start(){
//        thread.start();
//    }


}
