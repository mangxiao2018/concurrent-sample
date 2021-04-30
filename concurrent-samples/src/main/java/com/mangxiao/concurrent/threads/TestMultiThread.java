package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * TestMultiThread
 */
@Slf4j(topic = "c.TestMultiThread")
public class TestMultiThread {

    public static void main(String[] args){
        new Thread(() -> {
            while (true){
                log.debug("running...");
            }
        },"t1").start();

        new Thread(() -> {
            while (true){
                log.debug("running...");
            }
        },"t2").start();
    }
}
