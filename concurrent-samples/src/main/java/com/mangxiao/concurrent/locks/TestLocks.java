package com.mangxiao.concurrent.locks;

import lombok.extern.slf4j.Slf4j;

/**
 * TestLocks
 */
@Slf4j(topic = "c.TestLocks")
public class TestLocks {
    public static void main(String[] args){
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(()->{
            log.debug("begin");
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            log.debug("begin");
            n2.b();
        }).start();
    }
}

@Slf4j(topic = "c.Number")
class Number{
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        log.debug("1");
    }

    public synchronized void b(){
        log.debug("2");
    }
}
