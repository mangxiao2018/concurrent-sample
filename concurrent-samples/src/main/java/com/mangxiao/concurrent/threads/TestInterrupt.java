package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static com.mangxiao.concurrent.util.Sleeper.sleep;

/**
 * @description:TestInterrupt
 * @author:mangxiao2018@126.com
 * @date:2021-4-29
 */
@Slf4j(topic = "c.TestInterrupt")
public class TestInterrupt {
    public static void main() throws Exception {
        test1();
    }

    /**
     * test4
     */
    private static void test4(){
        Thread t1 = new Thread(() -> {
            for (int i=0; i<5; i++){
                log.debug("park...");
                LockSupport.park();
                log.debug("打断状态：{}",Thread.interrupted());
            }
        });
        t1.start();
        sleep(1);
        t1.interrupt();
    }

    /**
     * test3
     */
    private static void test3(){
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态:{}", Thread.currentThread().isInterrupted());
        },"t1");
        t1.start();

        sleep(0.5);
        t1.interrupt();
    }

    /**
     * test2
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true){
                Thread current = Thread.currentThread();
                boolean interupted = current.isInterrupted();
                if (interupted){
                    log.debug("打断状态：{}", interupted);
                    break;
                }
            }
        }, "t2");
        t2.start();

        sleep(0.5);
        t2.interrupt();
    }

    /**
     * test1
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException{
        Thread t1 = new Thread(() ->{
            sleep(1);
        }, "t1");
        t1.start();
        sleep(0.5);
        t1.interrupt();
        log.debug("打断状态:{}", t1.isInterrupted());
    }
}
