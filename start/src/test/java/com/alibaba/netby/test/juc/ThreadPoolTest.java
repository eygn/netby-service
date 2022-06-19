package com.alibaba.netby.test.juc;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author byg
 * @Date 2021/11/3 8:36
 * @Version 0.1
 **/
public class ThreadPoolTest {
    static List numbers = IntStream.range(0, 20).boxed().collect(Collectors.toList());
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            numbers.parallelStream().forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">" + num);
            });
        });

        Thread thread2 = new Thread(() -> {
            numbers.parallelStream().forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">>" + num);
            });
        });
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread2);

        threadPoolExecutor.shutdown();
    }
}
