package com.alibaba.netby.api.impl.utils;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.netby.api.utils.NetByUtilFacade;
import com.alibaba.netby.commons.CommonStateCode;
import com.alibaba.netby.commons.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author byg
 * @date 2022/7/3 14:20
 **/
@Slf4j
@CatchAndLog
@Service(version = "1.0")
public class NetByUtilFacadeImpl implements NetByUtilFacade {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate; //k-v都是对象

    @Override
    public Response sendMq(String topic, String tag, String body) {
        if (StringUtils.isAnyBlank(topic, tag, body)) {
            Results.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, "参数不能为空");
        }
        SendResult sendResult = rocketMQTemplate.syncSend(topic + ":" + tag, body);
        if (sendResult == null || !SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
            log.error("发送消息异常");
            return Results.newFailedResult(CommonStateCode.FAILED, "发送消息失败");
        }
        return Results.newSuccessResult(sendResult.getMsgId());
    }

    @Override
    public Response getCacheLongOrStringData(String key) {
        String msg = Objects.toString(redisTemplate.opsForValue().get(key), null);
        log.info("get redis, key:{}, value:{}", key, msg);
        return Results.newSuccessResult(msg);
    }
}
