package com.mangxiao.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestCorrectPostureStep1")
public class TestCorrectPostureStep1 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
   
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (room){
                log.debug("has cigarette:", hasCigarette);
                if (!hasCigarette){
                    log.debug("have a rest");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("has cigarette:", hasCigarette);
                if (hasCigarette){
                    log.debug("go...");
                }
            }
        },"xiao nan").start();

        for (int i=0;i<5;i++){
            new Thread(()->{
                synchronized (room){
                    log.debug("go...");
                }
            },"other").start();
        }

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (room){
                hasCigarette = true;
                log.debug("cigarette");
            }
        },"give").start();
    }
}
