package com.mangxiao.concurrent.bytecode;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.TestBiased")
public class TestBiased {

    public static void main(String[] args) throws InterruptedException {
        test5();
    }

    private static void test5() throws InterruptedException {
        log.debug("begin:");
        for (int i=0; i<6; i++){
            Dog d = new Dog();
            log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static Thread t1, t2, t3;

    private static void test4() throws InterruptedException {
        Vector<Dog> list = new Vector<>();

        int loopNumber = 39;
        t1 = new Thread(() ->{
           for (int i=0; i<loopNumber; i++){
               Dog d = new Dog();
               list.add(d);
               synchronized (d){
                   log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
               }
           }
            LockSupport.unpark(t2);
        },"t1");
        t1.start();

        t2 = new Thread(()->{
            LockSupport.park();
            for (int i=0; i<loopNumber; i++){
                Dog d = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                synchronized (d){
                    log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                }
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
            }
            LockSupport.park();
        },"t2");
        t2.start();

        t3 = new Thread(()->{
            LockSupport.park();
            log.debug("===========================>");
            for (int i=0; i<loopNumber; i++){
                Dog d = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                synchronized (d){
                    log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                }
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
            }
        },"t3");
        t3.start();

        t3.join();
        log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
    }

    public void test3(){
        Vector<Dog> list = new Vector<>();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 30; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                }
            }
            synchronized (list) {
                list.notify();
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("===============> ");
            for (int i = 0; i < 30; i++) {
                Dog d = list.get(i);      
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
                }
                log.debug(i + "\t" + ClassLayout.parseClass(Dog.class).toPrintable(true));
            }
        }, "t2");
        t2.start();
    }


    public void test2(){
        Dog d = new Dog();
        Thread t1 = new Thread(()->{
            synchronized (d){
                log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
            }
            synchronized (TestBiased.class){
                TestBiased.class.notify();
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(()->{
            synchronized (TestBiased.class){
                try {
                    TestBiased.class.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
            synchronized (d){
                log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
            }
            log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
        },"t2");
        t2.start();
    }
}
