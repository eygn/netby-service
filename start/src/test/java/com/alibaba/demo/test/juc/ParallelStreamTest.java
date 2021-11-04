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
public class ParallelStreamTest {
    static List numbers = IntStream.range(0, 20).boxed().collect(Collectors.toList());

    public static void main(String[] args) throws Exception {
        numbers.parallelStream().forEach(num -> {
            System.out.println(Thread.currentThread().getName() + ">" + num);
        });
        System.err.println(ForkJoinPool.commonPool().getPoolSize());
        System.err.println("over");
    }
}
