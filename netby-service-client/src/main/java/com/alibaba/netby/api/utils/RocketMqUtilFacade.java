package com.alibaba.netby.api.utils;

import com.alibaba.cola.dto.Response;

/**
 * @author byg
 * @date 2022/7/3 14:17
 **/
public interface RocketMqUtilFacade {

    public Response sendMq(String topic, String tag, String body);
}
