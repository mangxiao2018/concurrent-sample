package com.mangxiao.concurrent.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.DeadLock")
public class DeadLock {

    public static void main(String[] args){
        deadLock();
    }

    public static void deadLock(){
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(()->{
            synchronized (A){
                log.debug("lock A...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    log.debug("lock B...");
                    log.debug("操作...");
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (B){
                log.debug("lock B...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    log.debug("lock A...");
                    log.debug("操作...");
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
