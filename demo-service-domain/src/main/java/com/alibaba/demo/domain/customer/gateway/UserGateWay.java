package com.alibaba.demo.domain.customer.gateway;

import com.alibaba.demo.domain.customer.User;

/**
 * @author byg
 * @date 2022/3/27 19:30
 */
public interface UserGateWay {

    User getByById(String userId);
}
