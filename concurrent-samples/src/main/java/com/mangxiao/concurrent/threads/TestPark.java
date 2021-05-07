package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 测试park\interrupted\interrupt
 */
@Slf4j(topic = "c.TestPark")
public class TestPark {

    public static void main(String[] args) throws InterruptedException {
        TestPark p = new TestPark();
        p.test();
    }

    public void test() throws InterruptedException {
        Thread t = new Thread(()->{
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            //case1:
//            log.debug("打断状态:{}",Thread.currentThread().isInterrupted());

            //case2:
            log.debug("打断状态:{}",Thread.interrupted());
            LockSupport.park();
            log.debug("unpark...");

        },"t1");
        t.start();

        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }
}
