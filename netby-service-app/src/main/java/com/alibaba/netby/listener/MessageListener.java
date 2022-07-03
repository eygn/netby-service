package com.alibaba.netby.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author byg
 * @date 2022/7/2 20:51
 **/
@Slf4j
@Service
@RocketMQMessageListener(topic = "MQ_NETBY-1-b2ctrade", selectorExpression = "CREATE_ORDER", consumerGroup = "GID_NETBY-netbyservice")
public class MessageListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("消息内容:" + body);
        log.info("消息ID:" + message.getMsgId());
    }
}