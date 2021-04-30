package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * TestThread
 */
@Slf4j(topic = "c.TestThread")
public class TestThread {
    public static void main(){
        test1();
    }

    /**
     * 原始版
     */
    private static void test(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                log.debug("running...");
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }

    /**
     * lamd表达式过渡版
     */
    private static void test1(){
        Runnable runnable = () ->{
            log.debug("running...");
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }

    /**
     * lamd表达式最终版
     */
    private static void test2(){
        Thread t2 = new Thread(() ->{
            log.debug("running...");
        });
        t2.start();
    }

    /**
     * Thread实现版
     */
    private static void test3(){
        Thread t3 = new Thread(){
            @Override
            public void run() {
                log.debug("running...");
            }
        };
        t3.start();
    }
}
