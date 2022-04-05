package com.alibaba.demo.test.juc;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author byg
 * @Date 2021/11/4 7:48
 * @Version 0.1
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(20);
        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);
        ForkJoinPool pool = new ForkJoinPool(3);
        List<Integer> list = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        pool.submit(() -> {
            list.parallelStream().forEach(s -> {
                // 业务处理
                System.out.println("thread:" + Thread.currentThread().getName() + "value" + s);
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        });
        countDownLatch.await();
    }
}
