package com.alibaba.demo.api.impl.dubbo.user.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.demo.dto.data.user.UserDTO;
import com.alibaba.demo.dto.user.UserListByNameQry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserListByNameQryExe {
    public MultiResponse<UserDTO> execute(UserListByNameQry cmd) {
        List<UserDTO> customerDTOList = new ArrayList<>();
        UserDTO customerDTO = new UserDTO();
        customerDTO.setUsername("Frank");
        customerDTOList.add(customerDTO);
        return MultiResponse.of(customerDTOList);
    }
}
