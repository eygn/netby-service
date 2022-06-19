package com.alibaba.netby.test.juc;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description 两个线程按照顺序打印数组，线程一先执行
 * @Author byg
 * @Date 2021/11/6 17:25
 * @Version 0.1
 **/
public class ThreadOrderPrintTest {

    static List numbers = IntStream.range(0, 20).boxed().collect(Collectors.toList());
    static AtomicInteger currentIndex = new AtomicInteger(0);
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (currentIndex.get() % 2 == 1) {
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (currentIndex.get() >= numbers.size()) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ">" + numbers.get(currentIndex.getAndIncrement()));
                    condition2.signal();
                } finally {
                    condition2.signalAll();
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (currentIndex.get() % 2 == 0) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (currentIndex.get() >= numbers.size()) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ">" + numbers.get(currentIndex.getAndIncrement()));
                    condition1.signal();
                } finally {
                    condition1.signalAll();
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
