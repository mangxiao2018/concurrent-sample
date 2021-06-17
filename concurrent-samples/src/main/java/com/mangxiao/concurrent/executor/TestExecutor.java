package com.mangxiao.concurrent.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j(topic = "c.TestExecutor")
public class TestExecutor {
    public static void main(String[] args){

        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
        Executor executor = new ThreadPoolExecutor(2,5,10000,TimeUnit.SECONDS,workQueue);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                log.debug("executor ...");
            }
        });
    }
}
