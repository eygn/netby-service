package com.alibaba.netby.test;

/**
 * jdk的延迟队列
 *
 * @author byg
 * @date 2022/6/19 11:02
 **/

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueneTest {

    static DelayQueue<DelayTaskItem> queue = null;

    public static void main(String[] args) throws InterruptedException {

        queue = new DelayQueue<>();

        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        ProduceThread produceThread = new ProduceThread();
        produceThread.start();

        ConsumeThread consumeThread = new ConsumeThread();
        consumeThread.start();

    }

    // 添加任务线程
    public static class ProduceThread extends Thread {
        public ProduceThread() {

        }

        public void run() {

            DelayTaskItem item1 = new DelayTaskItem("item1", 5, TimeUnit.SECONDS);
            DelayTaskItem item2 = new DelayTaskItem("item2", 10, TimeUnit.SECONDS);
            DelayTaskItem item3 = new DelayTaskItem("item3", 15, TimeUnit.SECONDS);

            queue.put(item3);
            queue.put(item2);
            queue.put(item1);

            while (true) {
                DelayTaskItem item = new DelayTaskItem("item1", 5, TimeUnit.SECONDS);
                queue.put(item);

                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // 读取到期任务线程
    public static class ConsumeThread extends Thread {
        public ConsumeThread() {

        }

        public void run() {

            while (true) {
                DelayTaskItem item = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                try {
                    item = queue.take();
                    System.out.format("name:{%s}, delayed time:{%s},system time:{%s}\n",
                            item.name,
                            sdf.format(item.getTime()),
                            LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    // 延迟任务需要实现Delayed接口的getDelay()和compareTo()
    static class DelayTaskItem implements Delayed {
        /* 触发时间*/
        private long time;
        String name;

        public DelayTaskItem(String name, long time, TimeUnit unit) {
            this.name = name;
            this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            DelayTaskItem item = (DelayTaskItem) o;
            long diff = this.time - item.time;
            if (diff <= 0) {// 改成>=会造成问题
                return -1;
            } else {
                return 1;
            }
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "time=" + time +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}