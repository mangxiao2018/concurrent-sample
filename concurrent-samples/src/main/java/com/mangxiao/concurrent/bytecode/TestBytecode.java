package com.mangxiao.concurrent.bytecode;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * 通过jol-core打印类内存的字节码
 * -XX:-UseBiasedLocking 禁用偏向锁
 * -XX:BiasedLockingStartupDelay=0 延时为0
 */
@Slf4j(topic = "c.TestBytecode")
public class TestBytecode {

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.hashCode();
        log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));

        synchronized (dog){
            log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
        }

        log.debug(ClassLayout.parseClass(Dog.class).toPrintable(true));
    }


}

class Dog{

}