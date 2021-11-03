package com.alibaba.demo.test.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author byg
 * @Date 2021/11/3 8:36
 * @Version 0.1
 **/
public class ThreadJoinTest {
    static List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            numbers.forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">" + num);
            });
        });

        Thread thread2 = new Thread(() -> {
            numbers.forEach(num -> {
                System.out.println(Thread.currentThread().getName() + ">" + num);
            });
        });
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread2);

//        thread1.join();
//        thread2.join();
    }
}
