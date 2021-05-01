package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestStart")
public class TestStart {

    public static void main(){
        Thread t1 = new Thread("t1"){

            @Override
            public void run() {
                log.debug("running...");
                log.debug(Thread.currentThread().getName());
            }
        };
        t1.start();
        log.debug("do other things ...");
    }
}
