package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import static com.mangxiao.concurrent.util.Sleeper.sleep;
/**
 * @description:守候线程
 * @author:mangxiao2018@126.com
 * @date:2021-4-28
 */
@Slf4j(topic = "c.TestDaemon")
public class TestDaemon {

    public static void main(String[] args) {
        log.debug("开始运行...");
        Thread t1 = new Thread(() -> {
            log.debug("开始运行...");
            sleep(2);
            log.debug("运行结束...");
        }, "daemon");
        // 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();

        sleep(1);
        log.debug("运行结束...");
    }
}
