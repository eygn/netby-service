package com.alibaba.netby.user;

import com.alibaba.netby.domain.customer.User;
import com.alibaba.netby.domain.customer.gateway.UserGateWay;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserGatewayImpl extends ServiceImpl<UserMapper, UserDO> implements UserGateWay {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByById(String userId) {
        UserDO userDO = userMapper.selectById(userId);
        log.info("getByById,id={},result={}", userId, JSON.toJSONString(userDO));
        User user = new User();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }

    @Override
    public boolean saveOrUpdate(User user) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        return super.saveOrUpdate(userDO);
    }
}
