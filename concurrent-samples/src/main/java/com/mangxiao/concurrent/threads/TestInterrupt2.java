package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestInterrupt2")
public class TestInterrupt2 {

    public static void main(String[] args){
        Thread t1 = new Thread(()->{

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.debug("t1 is waked up...");
                e.printStackTrace();
            }
        });
        t1.start();
        log.debug(t1.getState().toString());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        log.debug(t1.getState().toString());
    }
}
