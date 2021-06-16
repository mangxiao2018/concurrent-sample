package com.mangxiao.concurrent.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.MyRunnable")
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        log.debug("My Runnable is running...");
    }
}
