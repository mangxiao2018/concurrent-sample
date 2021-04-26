package com.mangxiao.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Sync")
public class Sync {
    public static void main(String[] args) throws Exception{
        Thread.sleep(3*1000);
        log.debug("do some thing...");
    }
}
