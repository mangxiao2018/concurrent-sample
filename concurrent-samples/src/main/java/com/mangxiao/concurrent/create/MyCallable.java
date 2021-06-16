package com.mangxiao.concurrent.create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j(topic = "c.MyCallable")
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        log.debug("MyCallable is running...");
        return "ok";
    }
}
