package com.mangxiao.concurrent.priority;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestPriority")
public class TestPriority {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i < 2;i ++){
            Thread t = new Thread(()->{
                while (true){

                }
            },"t");
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }

        Thread.sleep(1000);
        Thread m = new Thread(()->{
            System.out.println("done");
        },"tm");
        m.setPriority(Thread.MAX_PRIORITY);
        m.start();
    }
}
