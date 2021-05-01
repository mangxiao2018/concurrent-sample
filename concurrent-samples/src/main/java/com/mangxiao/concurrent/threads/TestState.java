package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestState")
public class TestState {

    public static void main() throws Exception{
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.debug(String.valueOf(t1.getState()));

        Thread.sleep(500);
        log.debug(t1.getState().toString());
    }
}
