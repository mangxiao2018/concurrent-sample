package com.mangxiao.concurrent.async;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.async")
public class Async {

    public static void main(String[] args){
        new Thread(() -> {
            try {
                Thread.sleep(3*1000);
                log.debug("sleep over.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        log.debug("do some thing...");
    }
}

