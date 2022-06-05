package com.alibaba.demo.user;

import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateWay;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserGatewayImpl implements UserGateWay {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByById(String userId) {
        UserDO userDO = userMapper.selectById(userId);
        log.info("getByById,id={},result={}", userId, JSON.toJSONString(userDO));
        //Convert to User
        return null;
    }
}
