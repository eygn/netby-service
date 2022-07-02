package com.alibaba.netby.test;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author byg
 * @date 2022/7/2 20:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMqTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendMsg() {
        rocketMQTemplate.syncSend("MQ_NETBY-1-b2ctrade" + ":" + "CREATE_ORDER", "hello springboot rocketmq");
    }
}
