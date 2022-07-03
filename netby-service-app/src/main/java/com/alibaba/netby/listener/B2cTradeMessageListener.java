package com.alibaba.netby.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author byg
 * @date 2022/7/3 14:48
 **/
@Slf4j
@Service
@RocketMQMessageListener(topic = "MQ_NETBY-1-b2ctrade", selectorExpression = "CREATE_ORDER", consumerGroup = "GID_NETBY-netbyservice")
public class B2cTradeMessageListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("接收到消息,msgId:{}, topic:{}, tag:{},消息内容：{}", message.getMsgId(), message.getTopic(), message.getTags(), body);
    }
}