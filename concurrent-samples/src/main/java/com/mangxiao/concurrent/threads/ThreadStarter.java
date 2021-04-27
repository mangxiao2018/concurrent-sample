package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;
/**
 * @description:几种常用的线程创建方式
 * @author:mangxiao2018@126.com
 * @date:2021-4-27
 */
@Slf4j(topic = "c.ThreadStarter")
public class ThreadStarter {

    public static void main(String[] args) throws Exception{
        //线程创建方法1
        Thread t1 = new Thread("t1"){

            @Override
            public void run() {
                log.debug("hello");
            }
        };
        t1.start();

        //线程创建方法2
        Runnable task2 =() ->log.debug("hello");
        Thread t2 = new Thread(task2, "t2");
        t2.start();

        //线程创建方法3
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.debug("hello");
            return 100;
        });

        //线程创建方法4
        new Thread(task3, "t3").start();

        //线程创建方法5
        // 主线程阻塞，同步等待 task 执行完毕的结果
        Integer result = task3.get();
        log.debug("结果是:{}", result);
    }
}
