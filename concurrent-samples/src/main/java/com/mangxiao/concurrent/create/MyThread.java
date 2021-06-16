package com.mangxiao.concurrent.create;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.MyThread")
public class MyThread extends Thread{

    @Override
    public void run() {
        log.debug("MyThread is running...");
    }
}
