package com.alibaba.netby.api.user;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.netby.dto.data.user.UserDTO;
import com.alibaba.netby.dto.user.UserAddCmd;
import com.alibaba.netby.dto.user.UserListByNameQry;

public interface UserServiceFacade {

    public Response addCustomer(UserAddCmd customerAddCmd);

    public MultiResponse<UserDTO> listByName(UserListByNameQry userListByNameQry);
}
