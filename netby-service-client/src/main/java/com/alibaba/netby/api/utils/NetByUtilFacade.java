package com.alibaba.netby.api.utils;

import com.alibaba.cola.dto.Response;

/**
 * @author byg
 * @date 2022/7/3 14:17
 **/
public interface NetByUtilFacade {

    /**
     * 发送mq
     *
     * @param topic
     * @param tag
     * @param body
     * @return
     */
    Response sendMq(String topic, String tag, String body);


    /**
     * 获取缓存数据-RLong or RString
     *
     * @param key -
     * @return -
     */
    Response getCacheLongOrStringData(String key);

}
