package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * TestFutureTask
 */
@Slf4j(topic = "c.TestFutureTask")
public class TestFutureTask {

    public static void main(String[] args) throws Exception{
       test1();
    }

    public static void test1() throws Exception{
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running...");
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread t1 = new Thread(task,"t1");
        t1.start();
        log.debug("result:" + task.get());
    }

}
