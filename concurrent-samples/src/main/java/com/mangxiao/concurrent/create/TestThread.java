package com.mangxiao.concurrent.create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.TestThread")
public class TestThread {

    public static void main(String[] args){
        MyThread t;
        for (int i = 0; i < 10; i++){
            t = new MyThread();
            t.setName("Thread-" + i);
            t.start();
        }

        MyRunnable r;
        for (int i = 0; i < 10; i++){
            r = new MyRunnable();
            Thread t1 = new Thread(r);
            t1.setName("Runnable-" + i);
            t1.start();
        }

        for (int i = 0; i < 10; i++){
            FutureTask<String> ft = new FutureTask<String>(new MyCallable());
            Thread c = new Thread(ft);
            c.setName("MyCallable-" + i);
            c.start();
        }

    }
}
