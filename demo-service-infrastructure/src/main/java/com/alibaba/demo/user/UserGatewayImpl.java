package com.alibaba.demo.user;

import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayImpl implements UserGateWay {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByById(String userId) {
        UserDO userDO = userMapper.getById(userId);
        //Convert to User
        return null;
    }
}
