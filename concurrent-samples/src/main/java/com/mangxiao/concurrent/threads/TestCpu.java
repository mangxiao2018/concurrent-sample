package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:死循环测试CPU的负载
 * @author:mangxiao2018@126.com
 * @date:2021-4-26
 */
@Slf4j(topic = "c.TestCpu")
public class TestCpu {

    public static void main(String[] args){
        new Thread(() -> {
            while (true){
                // to do ...
            }
        }).start();
    }
}
