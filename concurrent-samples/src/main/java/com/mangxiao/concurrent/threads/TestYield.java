package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestYield")
public class TestYield {
    public static void main(String[] args){
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;){
                    log.debug("----->1" + count++);
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;){
                    Thread.yield();
                    log.debug("                 ----->2" + count++);
                }
            }
        };


        Thread t1 = new Thread(task1,"t1");
        Thread t2 = new Thread(task2,"t2");
        t1.start();
        t2.start();

    }
}
