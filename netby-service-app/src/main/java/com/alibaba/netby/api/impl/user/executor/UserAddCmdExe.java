
package com.alibaba.netby.api.impl.user.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.netby.domain.customer.User;
import com.alibaba.netby.domain.customer.gateway.UserGateWay;
import com.alibaba.netby.dto.data.user.UserDTO;
import com.alibaba.netby.dto.user.UserAddCmd;
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
