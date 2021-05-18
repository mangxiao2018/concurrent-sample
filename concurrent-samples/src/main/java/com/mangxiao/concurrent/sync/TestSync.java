package com.mangxiao.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestSync")
public class TestSync {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (TestSync.class){
                try {
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"t1");
        t1.start();

        Thread.sleep(100);
        new Thread(()->{
            synchronized (TestSync.class){

            }
        },"t2").start();

        new Thread(()->{
            synchronized (TestSync.class){

            }
        },"t3").start();
    }
}
