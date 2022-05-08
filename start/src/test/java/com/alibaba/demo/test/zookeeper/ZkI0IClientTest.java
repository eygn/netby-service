package com.alibaba.demo.test.zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * @author byg
 */
public class ZkI0IClientTest {


    private static final String PATH = "/test";

    // 建立zk链接，同步方法。ip:2181：服务器地址，50000：连接超时时间，在此范围内如果还未成功链接，则抛异常
    static ZkClient zkClient = new ZkClient("ibyg.net:2181", 50000);

    public static void main(String[] args) throws InterruptedException {

        try {
            // 注册一个监听事件，subscribeChildChanges，通过使用listen方式来监听来达到消息广播效果，监听子节点变化
            zkClient.subscribeChildChanges(PATH, new IZkChildListener() {
                @Override
                public void handleChildChange(String s, List<String> list) throws Exception {
                    System.out.println(">>>进入了handleChildChange");
                    System.out.println(">>>s = " + s);
                    System.out.println(">>>list = " + list);
                }
            });
            // 注册一个监听事件，subscribeDataChanges 监听节点上数据的变化
            zkClient.subscribeDataChanges(PATH, new IZkDataListener() {
                @Override
                public void handleDataChange(String dataPath, Object data) throws Exception {
                    System.out.println(">>> 进入了handleDataChange");
                    System.out.println(">>> dataPath = " + dataPath);
                    System.out.println(">>> data = " + data);
                }

                @Override
                public void handleDataDeleted(String dataPath) throws Exception {
                    System.out.println(">>> 进入了handleDataDeleted");
                    System.out.println(">>> dataPath = " + dataPath);
                }
            });

            // 监听zookeeper状态变化
            zkClient.subscribeStateChanges(new IZkStateListener() {
                @Override
                public void handleStateChanged(Watcher.Event.KeeperState state) throws Exception {
                    System.out.println(">>> 进入了subscribeStateChanges");
                    System.out.println(">>> state = " + state);
                }

                @Override
                public void handleNewSession() throws Exception {
                    System.out.println(">>> 进入了handleNewSession");
                }

                @Override
                public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
                    System.err.println(throwable.getMessage());
                }
            });

            if (!zkClient.exists(PATH)) {
                zkClient.createPersistent(PATH);
            }

            // 获取子节点
            List<String> children = zkClient.getChildren(PATH);

            // 创建节点
            createNode();


//        zkClient.createEphemeral(PATH, "123");

            Thread.sleep(1000);

            // 往节点上写数据
            zkClient.writeData(PATH, "456");

            // 检查节点是否存在
            zkClient.exists(PATH);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 删除节点
            deleteNode();

            zkClient.close();
        }

    }

    // 创建node
    public static void createNode() {

        // 创建一个永久的node节点a
        zkClient.createPersistent(PATH + "/a");

        // 创建一个永久性node节点b，这种创造方式和zookeeper的原生API很相识，不太一样的是隐藏了watcher注册和内容可以传object对象，zookeeper原生直接传数组
        // 节点类型：CreateMode有四种取值，大家可以自行脑补

        zkClient.create(PATH + "/b", "这里是内容", CreateMode.PERSISTENT);

        // 创建一个永久性node节点c/cc，true代表可以递归创建（如果c不存在，则会先创建c再创建cc节点），默认false（原生zookeeper Api不能跨层级创建，这就是ZKClient优势）
        zkClient.createPersistent(PATH + "/c/cc", true);

        // 创建永久性node节点d，里面内容为‘内容d’
        zkClient.createPersistent(PATH + "/d", "内容d");

        // 创建一个临时节点f
        zkClient.createEphemeral(PATH + "/f");

        // 创建一个临时节点g,内容为  ‘内容g’
        zkClient.createEphemeral(PATH + "/g", "内容g");

        // 创建一个  递增序号  临时节点h
        zkClient.createEphemeralSequential(PATH + "/h", "内容h");

        // 创建一个  递增序号  的永久节点i
        zkClient.createPersistentSequential(PATH + "/i", "内容i");

    }


    // 删除node
    public static void deleteNode() {
        // 删除节点c，以及节点c下面所有的子节点
        // 节点c下面，还有子节点cc，deleteRecursive方法可以递归的删除子节点，而zookeeper原生api不允许删除存在子节点的节点
        zkClient.deleteRecursive(PATH + "/c");

        // 删除节点a
        zkClient.delete(PATH + "/a");

        zkClient.deleteRecursive(PATH);
    }
}
