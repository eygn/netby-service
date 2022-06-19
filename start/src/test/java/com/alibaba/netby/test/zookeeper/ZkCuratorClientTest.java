package com.alibaba.netby.test.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.ZooDefs.Ids.ANYONE_ID_UNSAFE;

/**
 * @author byg
 * @date 2022/5/8 10:27
 **/
public class ZkCuratorClientTest {

    public static void main(String[] args) {
        try {
            // 计数器对象
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            // arg1:服务器的ip和端口
            // arg2:客户端与服务器之间的会话超时时间,以毫秒为单位
            // arg3:监视器对象，捕获客户端，因为调用ZooKeeper构造函数和process方法被执行是在两个线程中，需要利用信号量来同步两个操作。
            ZooKeeper zooKeeper = new ZooKeeper("ibyg.net:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("连接创建成功!");
                        countDownLatch.countDown();
                    }
                }
            });
            // 主线程阻塞等待连接对象的创建成功
            countDownLatch.await();
            System.out.println("准备关闭");
            // 会话编号
            System.out.println(zooKeeper.getSessionId());

            List<ACL> acl = new ArrayList<ACL>(Collections.singletonList(new ACL(ZooDefs.Perms.ALL, ANYONE_ID_UNSAFE)));

            zooKeeper.create("/test/abc", "hello".getBytes(StandardCharsets.UTF_8), acl, CreateMode.EPHEMERAL);
            zooKeeper.close();
        } catch (Exception ex) {
            System.out.println("关闭异常");
            ex.printStackTrace();
        }
    }

    @Test
    public void test_CuratorFramework() {
        String connectionString = "ibyg.net:2181";
        RetryPolicy retryPolicy = new RetryOneTime(1000);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
        System.err.println(JSON.toJSONString(curatorFramework.getState()));
        try {
            curatorFramework.blockUntilConnected(5, TimeUnit.SECONDS);
            curatorFramework.createContainers("/test/abc");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            curatorFramework.close();
        }

    }
}
