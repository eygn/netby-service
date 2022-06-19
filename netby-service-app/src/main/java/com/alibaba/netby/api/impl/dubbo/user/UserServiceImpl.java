package com.alibaba.netby.api.impl.dubbo.user;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.netby.api.impl.dubbo.user.executor.UserAddCmdExe;
import com.alibaba.netby.api.impl.dubbo.user.executor.query.UserListByNameQryExe;
import com.alibaba.netby.api.user.UserServiceI;
import com.alibaba.netby.dto.data.user.UserDTO;
import com.alibaba.netby.dto.user.UserAddCmd;
import com.alibaba.netby.dto.user.UserListByNameQry;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0")
@CatchAndLog
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UserAddCmdExe userAddCmdExe;

    @Resource
    private UserListByNameQryExe userListByNameQryExe;

    @Override
    public Response addCustomer(UserAddCmd userAddCmd) {
        return userAddCmdExe.execute(userAddCmd);
    }

    @Override
    public MultiResponse<UserDTO> listByName(UserListByNameQry userListByNameQry) {
        return userListByNameQryExe.execute(userListByNameQry);
    }

}