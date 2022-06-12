package com.alibaba.demo.api.user;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.demo.dto.data.user.UserDTO;
import com.alibaba.demo.dto.user.UserAddCmd;
import com.alibaba.demo.dto.user.UserListByNameQry;

public interface UserServiceI {

    public Response addCustomer(UserAddCmd customerAddCmd);

    public MultiResponse<UserDTO> listByName(UserListByNameQry userListByNameQry);
}
