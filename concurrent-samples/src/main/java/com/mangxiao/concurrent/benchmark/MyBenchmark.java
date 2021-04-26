package com.mangxiao.concurrent.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    static int x = 0;
    @Benchmark
    public void a() throws Exception{
        x++;
    }

    @Benchmark
    public void b() {
        Object o = new Object();
        synchronized (o){
            x++;
        }
    }
}
