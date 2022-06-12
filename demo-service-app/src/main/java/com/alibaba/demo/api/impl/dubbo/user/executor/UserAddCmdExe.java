
package com.alibaba.demo.api.impl.dubbo.user.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateWay;
import com.alibaba.demo.dto.data.user.UserDTO;
import com.alibaba.demo.dto.user.UserAddCmd;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class UserAddCmdExe {

    @Resource
    private UserGateWay userGateWay;

    public Response execute(UserAddCmd cmd) {
        UserDTO userDTO = cmd.getUserDTO();
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userGateWay.saveOrUpdate(user);
        return Response.buildSuccess();
    }

}
