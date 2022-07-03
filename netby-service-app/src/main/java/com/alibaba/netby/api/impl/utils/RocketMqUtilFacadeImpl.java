package com.alibaba.netby.api.impl.utils;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.netby.api.utils.RocketMqUtilFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import javax.annotation.Resource;

/**
 * @author byg
 * @date 2022/7/3 14:20
 **/
@Slf4j
@CatchAndLog
@Service(version = "1.0")
public class RocketMqUtilFacadeImpl implements RocketMqUtilFacade {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public Response sendMq() {
        SendResult sendResult = rocketMQTemplate.syncSend("MQ_NETBY-1-b2ctrade" + ":" + "CREATE_ORDER", "hello springboot rocketmq");
        if (sendResult == null || !SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            log.error("发送消息异常");
        }
        return Response.buildSuccess();
    }

}
