package com.alibaba.demo.dto.data.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
