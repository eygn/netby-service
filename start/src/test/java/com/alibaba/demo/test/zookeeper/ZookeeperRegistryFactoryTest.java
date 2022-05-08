package com.alibaba.demo.test.zookeeper;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistryFactory;
import com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter;
import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperTransporter;

/**
 * @author byg
 * @date 2022/5/8 13:52
 **/
public class ZookeeperRegistryFactoryTest {

    public static void main(String[] args) {
        ZookeeperRegistryFactory factory = new ZookeeperRegistryFactory();
        ZookeeperTransporter zookeeperTransporter = new CuratorZookeeperTransporter();
        factory.setZookeeperTransporter(zookeeperTransporter);
        URL url = new URL("zookeeper", "ibyg.net", 2181);
        url = url.addParameter(Constants.TIMEOUT_KEY, "10000");
        factory.createRegistry(url);
    }
}
