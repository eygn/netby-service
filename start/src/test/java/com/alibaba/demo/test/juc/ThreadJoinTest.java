package com.alibaba.demo.test.juc;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author byg
 * @Date 2021/11/3 8:36
 * @Version 0.1
 **/
public class ThreadJoinTest {
    static List numbers = IntStream.range(0, 20).boxed().collect(Collectors.toList());

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            numbers.stream().forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">" + num);
            });
        });

        Thread thread2 = new Thread(() -> {
            numbers.stream().forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">>" + num);
            });
        });

        thread1.start();
        thread1.join();

        System.err.println("线程一已执行完成");

        thread2.start();
        thread2.join();

        int poolSize = ForkJoinPool.commonPool().getPoolSize();
        System.out.println("Pool size: " + poolSize);
    }
}
