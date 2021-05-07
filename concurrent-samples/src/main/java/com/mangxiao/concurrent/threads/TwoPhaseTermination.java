package com.mangxiao.concurrent.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程打断练习
 */
@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination {
    private Thread t;
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tt = new TwoPhaseTermination();
        tt.start();
        TimeUnit.SECONDS.sleep(5);
        tt.stop();
    }


    public void start(){
        t = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if (current.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    log.debug("执行监控....");
                }catch (InterruptedException e){
                    e.printStackTrace();
                    //因为sleep异常后会清除打断标记
                    //需要重新设置打断标记
                    current.interrupt();
                }
            }
        });
        t.start();
    }

    public void stop(){
        t.interrupt();
    }
}
