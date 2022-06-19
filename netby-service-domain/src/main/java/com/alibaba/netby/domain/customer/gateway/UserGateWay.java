package com.alibaba.netby.domain.customer.gateway;

import com.alibaba.netby.domain.customer.User;

/**
 * @author byg
 * @date 2022/3/27 19:30
 */
public interface UserGateWay {

    User getByById(String userId);

    boolean saveOrUpdate(User user);
}
